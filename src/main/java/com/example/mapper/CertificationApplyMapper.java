package com.example.mapper;

import com.example.entity.CertificationApply;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CertificationApplyMapper {
    int insert(CertificationApply certificationApply);
    int deleteById(Integer id);
    int deleteBatch(List<Integer> ids);
    int updateById(CertificationApply certificationApply);
    CertificationApply selectById(Integer id);
    List<CertificationApply> selectAll(CertificationApply certificationApply);
}