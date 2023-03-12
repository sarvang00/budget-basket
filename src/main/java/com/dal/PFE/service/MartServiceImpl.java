package com.dal.PFE.service;

import com.dal.PFE.dao.MartDao;
import com.dal.PFE.model.Aide;
import com.dal.PFE.model.Kroger;
import com.dal.PFE.model.TraderJoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MartServiceImpl implements MartService{
    @Autowired
    MartDao martDao;

    @Override
    @Transactional
    public List<Kroger> getAllProductFromKroger() {
        return martDao.getAllProductFromKroger();
    }

    @Override
    @Transactional
    public List<Aide> getAllProductFromAide() {
        return martDao.getAllProductFromAide();
    }

    @Override
    @Transactional
    public List<TraderJoe> getAllProductFromTraderJoe() {
        return martDao.getAllProductFromTraderJoe();
    }
}
