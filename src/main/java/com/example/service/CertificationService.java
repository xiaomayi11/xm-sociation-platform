package com.example.service;

import cn.hutool.core.date.DateUtil;
import com.example.entity.Certification;
import com.example.entity.CertificationApply;
import com.example.mapper.CertificationMapper;
import com.example.mapper.CertificationApplyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificationService {

    @Resource
    private CertificationMapper certificationMapper;
    @Resource
    private CertificationApplyMapper certificationApplyMapper;

    public void add(Certification certification) {
        certification.setCreateTime(DateUtil.now());
        certificationMapper.insert(certification);
    }

    public void updateById(Certification certification) {
        certificationMapper.updateById(certification);
    }

    public void deleteById(Integer id) {
        certificationMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        certificationMapper.deleteBatch(ids);
    }

    public Certification selectById(Integer id) {
        return certificationMapper.selectById(id);
    }

    public List<Certification> selectAll(Certification certification) {
        return certificationMapper.selectAll(certification);
    }

    public PageInfo<Certification> selectPage(Integer pageNum, Integer pageSize, Certification certification) {
        PageHelper.startPage(pageNum, pageSize);
        List<Certification> list = certificationMapper.selectAll(certification);
        return PageInfo.of(list);
    }

    public void addApply(CertificationApply certificationApply) {
        CertificationApply query = new CertificationApply();
        query.setCertificationId(certificationApply.getCertificationId());
        query.setUserId(certificationApply.getUserId());
        List<CertificationApply> existing = certificationApplyMapper.selectAll(query);
        if (existing != null && !existing.isEmpty()) {
            throw new RuntimeException("你已报名该考试");
        }
        certificationApply.setTime(DateUtil.now());
        certificationApply.setStatus("PENDING");
        certificationApplyMapper.insert(certificationApply);
        Certification certification = certificationMapper.selectById(certificationApply.getCertificationId());
        if (certification != null) {
            Certification update = new Certification();
            update.setId(certification.getId());
            update.setApplyCount((certification.getApplyCount() == null ? 0 : certification.getApplyCount()) + 1);
            certificationMapper.updateById(update);
        }
    }

    public void updateApplyById(CertificationApply certificationApply) {
        certificationApplyMapper.updateById(certificationApply);
    }

    public List<CertificationApply> selectApplyAll(CertificationApply certificationApply) {
        return certificationApplyMapper.selectAll(certificationApply);
    }

    public PageInfo<CertificationApply> selectApplyPage(Integer pageNum, Integer pageSize, CertificationApply certificationApply) {
        PageHelper.startPage(pageNum, pageSize);
        List<CertificationApply> list = certificationApplyMapper.selectAll(certificationApply);
        return PageInfo.of(list);
    }
}