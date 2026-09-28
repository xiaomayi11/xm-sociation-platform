package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Team;
import com.example.entity.TeamApplication;
import com.example.entity.TeamMember;
import com.example.mapper.TeamApplicationMapper;
import com.example.mapper.TeamMapper;
import com.example.mapper.TeamMemberMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    @Resource
    private TeamMapper teamMapper;
    @Resource
    private TeamMemberMapper teamMemberMapper;
    @Resource
    private TeamApplicationMapper teamApplicationMapper;

    public void add(Team team) {
        team.setCreateTime(DateUtil.now());
        team.setMemberCount(1);
        team.setStatus("ACTIVE");
        teamMapper.insert(team);
        TeamMember leader = new TeamMember();
        leader.setTeamId(team.getId());
        leader.setUserId(team.getLeaderId());
        leader.setUserName(team.getLeaderName());
        leader.setRole("LEADER");
        leader.setJoinTime(DateUtil.now());
        teamMemberMapper.insert(leader);
    }

    @Transactional
    public void applyToJoin(TeamApplication application) {
        Team team = teamMapper.selectById(application.getTeamId());
        if (team == null || !"ACTIVE".equals(team.getStatus())) {
            throw new RuntimeException("队伍不存在或已结束招募");
        }
        TeamApplication query = new TeamApplication();
        query.setTeamId(application.getTeamId());
        query.setUserId(application.getUserId());
        List<TeamApplication> existing = teamApplicationMapper.selectAll(query);
        if (existing != null && !existing.isEmpty()) {
            boolean hasPending = existing.stream().anyMatch(a -> "PENDING".equals(a.getStatus()));
            if (hasPending) {
                throw new RuntimeException("你已申请过该队伍，请等待队长审核");
            }
            boolean hasApproved = existing.stream().anyMatch(a -> "APPROVED".equals(a.getStatus()));
            if (hasApproved) {
                throw new RuntimeException("你已经是该队伍成员");
            }
        }
        TeamMember memberQuery = new TeamMember();
        memberQuery.setTeamId(application.getTeamId());
        memberQuery.setUserId(application.getUserId());
        List<TeamMember> members = teamMemberMapper.selectAll(memberQuery);
        if (members != null && !members.isEmpty()) {
            throw new RuntimeException("你已在该队伍中");
        }
        application.setStatus("PENDING");
        application.setCreateTime(DateUtil.now());
        teamApplicationMapper.insert(application);
    }

    @Transactional
    public void handleApplication(Integer applicationId, String status) {
        TeamApplication application = teamApplicationMapper.selectById(applicationId);
        if (application == null || !"PENDING".equals(application.getStatus())) {
            throw new RuntimeException("该申请已处理");
        }
        application.setStatus(status);
        teamApplicationMapper.updateById(application);

        if ("APPROVED".equals(status)) {
            Team team = teamMapper.selectById(application.getTeamId());
            if (team.getMemberCount() != null && team.getMemberCount() >= team.getMaxMembers()) {
                throw new RuntimeException("队伍已满员");
            }
            TeamMember member = new TeamMember();
            member.setTeamId(application.getTeamId());
            member.setUserId(application.getUserId());
            member.setUserName(application.getUserName());
            member.setRole("MEMBER");
            member.setJoinTime(DateUtil.now());
            teamMemberMapper.insert(member);

            Team update = new Team();
            update.setId(team.getId());
            update.setMemberCount((team.getMemberCount() == null ? 0 : team.getMemberCount()) + 1);
            teamMapper.updateById(update);
        }
    }

    @Transactional
    public void joinTeam(TeamMember teamMember) {
        Team team = teamMapper.selectById(teamMember.getTeamId());
        if (team == null || !"ACTIVE".equals(team.getStatus())) {
            throw new RuntimeException("队伍不存在或已结束招募");
        }
        TeamMember queryMember = new TeamMember();
        queryMember.setTeamId(teamMember.getTeamId());
        queryMember.setUserId(teamMember.getUserId());
        List<TeamMember> members = teamMemberMapper.selectAll(queryMember);
        if (members != null && !members.isEmpty()) {
            throw new RuntimeException("你已在该队伍中");
        }
        if (team.getMemberCount() != null && team.getMemberCount() >= team.getMaxMembers()) {
            throw new RuntimeException("队伍已满员");
        }
        teamMember.setJoinTime(DateUtil.now());
        teamMember.setRole("MEMBER");
        teamMemberMapper.insert(teamMember);
        Team update = new Team();
        update.setId(team.getId());
        update.setMemberCount((team.getMemberCount() == null ? 0 : team.getMemberCount()) + 1);
        teamMapper.updateById(update);
    }

    public void updateById(Team team) {
        teamMapper.updateById(team);
    }

    @Transactional
    public void deleteById(Integer id) {
        teamMapper.deleteById(id);
    }

    @Transactional
    public void deleteBatch(List<Integer> ids) {
        teamMapper.deleteBatch(ids);
    }

    public Team selectById(Integer id) {
        return teamMapper.selectById(id);
    }

    public List<Team> selectAll(Team team) {
        return teamMapper.selectAll(team);
    }

    public PageInfo<Team> selectPage(Integer pageNum, Integer pageSize, Team team) {
        PageHelper.startPage(pageNum, pageSize);
        List<Team> list = teamMapper.selectAll(team);
        return PageInfo.of(list);
    }

    public void addMember(TeamMember teamMember) {
        teamMember.setJoinTime(DateUtil.now());
        teamMemberMapper.insert(teamMember);
    }

    public void deleteMemberById(Integer id) {
        TeamMember member = teamMemberMapper.selectById(id);
        if (member != null) {
            teamMemberMapper.deleteById(id);
            Team team = teamMapper.selectById(member.getTeamId());
            if (team != null) {
                Team update = new Team();
                update.setId(team.getId());
                update.setMemberCount(Math.max(0, (team.getMemberCount() == null ? 0 : team.getMemberCount()) - 1));
                teamMapper.updateById(update);
            }
        }
    }

    public List<TeamMember> selectMembers(TeamMember teamMember) {
        return teamMemberMapper.selectAll(teamMember);
    }

    public List<TeamApplication> selectApplications(TeamApplication teamApplication) {
        return teamApplicationMapper.selectAll(teamApplication);
    }

    public void deleteApplicationById(Integer id) {
        teamApplicationMapper.deleteById(id);
    }
}
