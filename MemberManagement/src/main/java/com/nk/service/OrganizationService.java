package com.nk.service;

import com.nk.domain.Organization;

import java.util.List;

public interface OrganizationService {
    public Organization findOrganizationByAO(String name, String ascription);
    public List<Organization> organization_List();
    public Organization findOrganizationById(Integer id);
    public int deleteOrganizationById(Integer id);
    public int addOrganization(String name,String ascription);
}
