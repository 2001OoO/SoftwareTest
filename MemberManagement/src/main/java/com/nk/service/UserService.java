package com.nk.service;

import com.nk.domain.Organization;
import com.nk.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserService {
    public int addUser(User user);
    public int deleteUserById(Integer id);
    public int updateUserById(Integer id, String username, String password, Integer organization_id, Integer jurisdiction_id,
                              Date register_time, String number);
    public User findUserById(Integer id);
    public User findUserByNumber(String number);
    public String findJurisdictionById(Integer id);
    public Organization findOrganizationById(Integer id);
    public List<User> findAllUser();
}
