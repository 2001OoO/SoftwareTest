package com.nk.mapper;

import com.nk.domain.Organization;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrganizationMapper {

    @Select("select * from organization where name = #{name} and ascription = #{ascription}")
    public Organization findOrganizationByAO(@Param("name") String name, @Param("ascription") String ascription);

    @Select("select * from organization")
    public List<Organization> organization_List();

    @Select("select * from organization where id=#{id}")
    public Organization findOrganizationById(Integer id);

    @Delete("delete from organization where id=#{id}")
    public int deleteOrganizationById(Integer id);

    @Insert("insert into organization (name, ascription) values (#{name},#{ascription})")
    public int addOrganization(@Param("name") String name, @Param("ascription") String ascription);
}
