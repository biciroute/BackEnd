package edu.eci.BiciRoute.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.BiciRoute.Models.Bicicle;
import edu.eci.BiciRoute.Repositories.IBicicleRepository;
import edu.eci.BiciRoute.services.IBicicleService;

@Component
public class BicicleService implements IBicicleService {

    @Autowired
    IBicicleRepository bicicleRepository;

    @Override
    public Bicicle getBicicle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveBicicle(Bicicle bicicle) {
        bicicleRepository.save(bicicle);
    }

    @Override
    public void updateBicicle(Bicicle bicicle){
        bicicleRepository.save(bicicle);
    }


}
