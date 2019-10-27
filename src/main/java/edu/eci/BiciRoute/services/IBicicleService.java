package edu.eci.BiciRoute.services;

import edu.eci.BiciRoute.Models.Bicicle;

public interface IBicicleService {

    Bicicle getBicicle();
    void saveBicicle(Bicicle bicicle);

}
