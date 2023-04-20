package com.nk.service;

import com.nk.domain.Ascription;
import com.nk.mapper.AscriptionMapper;

import java.util.List;

public interface AscriptionService {
    public List<Ascription> ascription_List();

    public int deleteAscription(String name);
    public int addAscription(String name);
}
