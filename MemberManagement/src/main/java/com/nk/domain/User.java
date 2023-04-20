package com.nk.domain;

import java.util.Date;

public class User {
    private Integer id;
    private String number;
    private String username;
    private String password;
    private Integer organization_id;
    private Date register_time;
    private Integer jurisdiction_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(Integer organization_id) {
        this.organization_id = organization_id;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }

    public Integer getJurisdiction_id() {
        return jurisdiction_id;
    }

    public void setJurisdiction_id(Integer jurisdiction_id) {
        this.jurisdiction_id = jurisdiction_id;
    }
}
