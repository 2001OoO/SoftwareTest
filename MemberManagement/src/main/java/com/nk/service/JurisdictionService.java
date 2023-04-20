package com.nk.service;

import com.nk.domain.Jurisdiction;

import java.util.List;

public interface JurisdictionService {
    public Jurisdiction findJurisdictionById(Integer id);
    public List<Jurisdiction> findAllJurisdiction();
    public Jurisdiction findIdByJurisdiction(String name);
}
