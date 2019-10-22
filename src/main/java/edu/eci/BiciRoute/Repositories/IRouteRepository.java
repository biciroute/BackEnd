package edu.eci.BiciRoute.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.BiciRoute.Models.Route;

public interface IRouteRepository extends MongoRepository<Route, String> {
    List<Route> findAllByUsersContains(String id);

    Route findBy_id(String id);

}
