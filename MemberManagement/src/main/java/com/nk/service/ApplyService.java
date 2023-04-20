package com.nk.service;

import com.nk.domain.Apply;

import java.util.List;

public interface ApplyService {
    public int insertApply(Apply apply);
    public List<Apply> findAllApply();
    public int deleteApplyById(Integer id);
    public Apply findApplyById(Integer id);
}
