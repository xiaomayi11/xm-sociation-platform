package com.example.controller;

import com.example.common.Result;
import com.example.entity.Team;
import com.example.entity.TeamApplication;
import com.example.entity.TeamMember;
import com.example.service.TeamService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Resource
    private TeamService teamService;

    @PostMapping("/add")
    public Result add(@RequestBody Team team) {
        teamService.add(team);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Team team) {
        teamService.updateById(team);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        teamService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        teamService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(Team team) {
        return Result.success(teamService.selectAll(team));
    }

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             Team team) {
        PageInfo<Team> pageInfo = teamService.selectPage(pageNum, pageSize, team);
        return Result.success(pageInfo);
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        return Result.success(teamService.selectById(id));
    }

    @PostMapping("/join")
    public Result join(@RequestBody TeamMember teamMember) {
        teamService.joinTeam(teamMember);
        return Result.success();
    }

    @PostMapping("/apply")
    public Result apply(@RequestBody TeamApplication application) {
        teamService.applyToJoin(application);
        return Result.success();
    }

    @PutMapping("/application/handle")
    public Result handleApplication(@RequestBody Map<String, Object> params) {
        Integer applicationId = Integer.valueOf(params.get("applicationId").toString());
        String status = params.get("status").toString();
        teamService.handleApplication(applicationId, status);
        return Result.success();
    }

    @GetMapping("/application/selectAll")
    public Result applicationSelectAll(TeamApplication teamApplication) {
        return Result.success(teamService.selectApplications(teamApplication));
    }

    @DeleteMapping("/application/delete/{id}")
    public Result applicationDelete(@PathVariable Integer id) {
        teamService.deleteApplicationById(id);
        return Result.success();
    }

    @GetMapping("/member/selectAll")
    public Result memberSelectAll(TeamMember teamMember) {
        return Result.success(teamService.selectMembers(teamMember));
    }

    @DeleteMapping("/member/delete/{id}")
    public Result memberDelete(@PathVariable Integer id) {
        teamService.deleteMemberById(id);
        return Result.success();
    }
}
