package com.nk.service.impl;

import com.nk.domain.Apply;
import com.nk.mapper.ApplyMapper;
import com.nk.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;

    @Override
    public int insertApply(Apply apply) {
        return applyMapper.insertApply(apply);
    }

    @Override
    public List<Apply> findAllApply() {
        return applyMapper.findAllApply();
    }

    @Override
    public int deleteApplyById(Integer id) {
        return applyMapper.deleteApplyById(id);
    }

    @Override
    public Apply findApplyById(Integer id) {
        return applyMapper.findApplyById(id);
    }
}
