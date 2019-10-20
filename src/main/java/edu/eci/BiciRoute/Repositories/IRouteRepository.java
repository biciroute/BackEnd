package edu.eci.BiciRoute.Repositories;

import edu.eci.BiciRoute.Models.Route;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IRouteRepository extends MongoRepository<Route, String> {
    List<Route> findAllByUsersContains(String id);

    Route findBy_id(String id);

}
