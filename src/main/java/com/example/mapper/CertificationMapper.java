package com.example.mapper;

import com.example.entity.Certification;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CertificationMapper {
    int insert(Certification certification);
    int deleteById(Integer id);
    int deleteBatch(List<Integer> ids);
    int updateById(Certification certification);
    Certification selectById(Integer id);
    List<Certification> selectAll(Certification certification);
}