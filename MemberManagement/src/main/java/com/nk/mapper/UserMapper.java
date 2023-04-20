package com.nk.mapper;

import com.nk.domain.Organization;
import com.nk.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;


@Mapper
public interface UserMapper {
    @Insert("insert into user (username, password, organization_id, register_time, jurisdiction_id, number) values " +
            "(#{username}, #{password}, #{organization_id}, #{register_time}, #{jurisdiction_id}, #{number})")
    public int addUser(User user);

    @Delete("delete from user where id = #{id}")
    public int deleteUserById(Integer id);

    @Update("update user set username = #{username}, password = #{password}, organization_id = #{organization_id}," +
            "register_time = #{register_time}, jurisdiction_id = #{jurisdiction_id}, number = #{number} where id = #{id}")
    public int updateUserById(@Param("id") Integer id, @Param("username") String username, @Param("password") String password,
                              @Param("organization_id") Integer organization_id,
                              @Param("jurisdiction_id") Integer jurisdiction_id,
                              @Param("register_time") Date register_time, @Param("number") String number);

    @Select("select * from user where id = #{id}")
    public User findUserById(Integer id);

    @Select("select * from user where number = #{number}")
    public User findUserByNumber(String number);

//    根据id找权限
    @Select("select name from jurisdiction where id = #{id}")
    public String findJurisdictionById(Integer id);

    //    根据id找组织
    @Select("select * from organization where id = #{id}")
    public Organization findOrganizationById(Integer id);

    @Select("select * from user")
    public List<User> findAllUser();

}
