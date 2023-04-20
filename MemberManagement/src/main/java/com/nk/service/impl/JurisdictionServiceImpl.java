package com.nk.service.impl;

import com.nk.domain.Jurisdiction;
import com.nk.mapper.JurisdictionMapper;
import com.nk.service.JurisdictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JurisdictionServiceImpl implements JurisdictionService {

    @Autowired
    private JurisdictionMapper jurisdictionMapper;

    @Override
    public Jurisdiction findJurisdictionById(Integer id) {
        return jurisdictionMapper.findJurisdictionById(id);
    }

    @Override
    public List<Jurisdiction> findAllJurisdiction() {
        return jurisdictionMapper.findAllJurisdiction();
    }

    @Override
    public Jurisdiction findIdByJurisdiction(String name) {
        return jurisdictionMapper.findIdByJurisdiction(name);
    }
}
