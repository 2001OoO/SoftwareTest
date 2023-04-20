package com.nk.service.impl;

import com.nk.domain.Ascription;
import com.nk.mapper.AscriptionMapper;
import com.nk.service.AscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AscriptionServiceImpl implements AscriptionService {

    @Autowired
    private AscriptionMapper ascriptionMapper;

    @Override
    public List<Ascription> ascription_List() {
        return ascriptionMapper.ascription_List();
    }

    @Override
    public int deleteAscription(String name) {
        return ascriptionMapper.deleteAscription(name);
    }

    @Override
    public int addAscription(String name) {
        return ascriptionMapper.addAscription(name);
    }


}
