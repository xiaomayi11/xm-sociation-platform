package com.example.service;

import com.example.entity.Competition;
import com.example.mapper.CompetitionMapper;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompetitionService {

    @Resource
    private CompetitionMapper competitionMapper;

    public void add(Competition competition) {
        competitionMapper.insert(competition);
    }

    public void updateById(Competition competition) {
        competitionMapper.updateById(competition);
    }

    public void deleteById(Integer id) {
        competitionMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            competitionMapper.deleteById(id);
        }
    }

    public Competition selectById(Integer id) {
        return competitionMapper.selectById(id);
    }

    public List<Competition> selectAll(Competition competition) {
        return competitionMapper.selectAll(competition);
    }

    public PageInfo<Competition> selectPage(Integer pageNum, Integer pageSize, Competition competition) {
        PageHelper.startPage(pageNum, pageSize);
        List<Competition> list = competitionMapper.selectAll(competition);
        return new PageInfo<>(list);
    }

    public List<Competition> selectRegistering() {
        List<Competition> all = competitionMapper.selectAll(new Competition());
        List<Competition> result = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Competition comp : all) {
            String timeline = comp.getTimeline();
            if (timeline == null || timeline.isEmpty()) continue;
            try {
                JSONArray stages = JSONUtil.parseArray(timeline);
                for (int i = 0; i < stages.size(); i++) {
                    JSONObject stage = stages.getJSONObject(i);
                    String startStr = stage.getStr("start");
                    String endStr = stage.getStr("end");
                    if (startStr == null || endStr == null) continue;
                    LocalDate start = LocalDate.parse(startStr);
                    LocalDate end = LocalDate.parse(endStr);
                    if (!today.isBefore(start) && !today.isAfter(end)) {
                        result.add(comp);
                        break;
                    }
                }
            } catch (Exception ignored) {
            }
        }
        return result;
    }
}