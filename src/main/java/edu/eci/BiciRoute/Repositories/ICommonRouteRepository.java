package edu.eci.BiciRoute.Repositories;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import edu.eci.BiciRoute.Models.CommonRoute;
import edu.eci.BiciRoute.Models.Point;

public interface ICommonRouteRepository extends MongoRepository<CommonRoute, String> {
    Point findBy_id(ObjectId _id);

    CommonRoute findByHour(Date date);

    @Query(value="{ $and: [{'origin' : { $eq : ?0}}, {'destination' : { $eq : ?1}} ]}")
    List<CommonRoute> findByPoint(ObjectId origin_id, ObjectId destination_id);


}