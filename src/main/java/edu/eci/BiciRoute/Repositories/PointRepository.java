package edu.eci.BiciRoute.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.BiciRoute.Models.Point;

public interface PointRepository extends MongoRepository<Point, String> {
    Point findBy_id(ObjectId _id);
}