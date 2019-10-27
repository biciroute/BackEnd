package edu.eci.BiciRoute.Repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import edu.eci.BiciRoute.Models.Route;

public interface IRouteRepository extends MongoRepository<Route, String> {
    Route findBy_id(String id);

    @Query(value = "{ 'user' : { $eq : ?0} }")
    List<Route> findRoutesByUser(ObjectId user_id);
}
