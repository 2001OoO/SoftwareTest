package com.nk.service.impl;

import com.nk.domain.Organization;
import com.nk.mapper.OrganizationMapper;
import com.nk.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public Organization findOrganizationByAO(String name, String ascription) {
        System.out.println(name+ascription);
        return organizationMapper.findOrganizationByAO(name, ascription);
    }

    @Override
    public List<Organization> organization_List() {
        return organizationMapper.organization_List();
    }

    @Override
    public Organization findOrganizationById(Integer id) {
        return organizationMapper.findOrganizationById(id);
    }

    @Override
    public int deleteOrganizationById(Integer id) {
        return organizationMapper.deleteOrganizationById(id);
    }

    @Override
    public int addOrganization(String name, String ascription) {
        return organizationMapper.addOrganization(name,ascription);
    }
}
