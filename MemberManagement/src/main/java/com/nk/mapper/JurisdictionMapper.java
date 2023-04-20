package com.nk.mapper;

import com.nk.domain.Jurisdiction;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JurisdictionMapper {
    @Select("select * from jurisdiction where id=#{id}")
    public Jurisdiction findJurisdictionById(Integer id);

    @Select("select * from jurisdiction")
    public List<Jurisdiction> findAllJurisdiction();

    @Select("select id from jurisdiction where name=#{name}")
    public Jurisdiction findIdByJurisdiction(@Param("name") String name);
}
