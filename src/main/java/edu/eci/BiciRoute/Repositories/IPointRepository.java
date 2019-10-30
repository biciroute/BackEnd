package edu.eci.BiciRoute.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.BiciRoute.Models.Point;

import java.util.List;

public interface IPointRepository extends MongoRepository<Point, String> {
    Point findBy_id(ObjectId _id);
    List<Point> findByCommonIsTrue();
}