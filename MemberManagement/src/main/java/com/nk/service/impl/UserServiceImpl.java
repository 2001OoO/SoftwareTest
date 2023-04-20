package com.nk.service.impl;

import com.google.protobuf.Enum;
import com.nk.domain.Organization;
import com.nk.domain.User;
import com.nk.mapper.UserMapper;
import com.nk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUserById(Integer id, String username, String password, Integer organization_id, Integer jurisdiction_id, Date register_time, String number) {
        return userMapper.updateUserById(id, username, password, organization_id, jurisdiction_id, register_time, number);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserByNumber(String number) {
        return userMapper.findUserByNumber(number);
    }

    @Override
    public String findJurisdictionById(Integer id) {
        return userMapper.findJurisdictionById(id);
    }

    @Override
    public Organization findOrganizationById(Integer id) {
        return userMapper.findOrganizationById(id);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }
}
