package com.dal.PFE.service;

import com.dal.PFE.model.Aide;
import com.dal.PFE.model.Kroger;
import com.dal.PFE.model.TraderJoe;

import java.util.List;

public interface MartService {

    List<Kroger> getAllProductFromKroger();
    List<Aide> getAllProductFromAide();
    List<TraderJoe> getAllProductFromTraderJoe();


}
