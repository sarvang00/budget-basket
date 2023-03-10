package com.dal.PFE.dao;

import com.dal.PFE.model.Aide;
import com.dal.PFE.model.Kroger;
import com.dal.PFE.model.TraderJoe;
import com.dal.PFE.repository.AideRepository;
import com.dal.PFE.repository.KrogerRepository;
import com.dal.PFE.repository.TraderJoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MartDaoImpl implements MartDao{


    @Autowired
    KrogerRepository krogerRepository;

    @Autowired
    TraderJoeRepository traderJoeRepository;

    @Autowired
    AideRepository aideRepository;

    @Override
    public List<Kroger> getAllProductFromKroger() {

        return krogerRepository.findAll();
    }

    @Override
    public List<Aide> getAllProductFromAide() {
        return aideRepository.findAll();
    }

    @Override
    public List<TraderJoe> getAllProductFromTraderJoe() {
        return traderJoeRepository.findAll();
    }
}
