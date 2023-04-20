package com.nk.mapper;

import com.nk.domain.Apply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ApplyMapper {
    @Insert("insert into apply (username, password, organization_id) values (#{username}, #{password}, #{organization_id})")
    public int insertApply(Apply apply);

    @Select("select * from apply")
    public List<Apply> findAllApply();

    @Delete("delete from apply where id=#{id}")
    public int deleteApplyById(Integer id);

    @Select("select * from apply where id = #{id}")
    public Apply findApplyById(Integer id);
}
