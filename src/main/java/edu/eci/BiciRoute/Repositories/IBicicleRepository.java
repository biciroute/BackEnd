package edu.eci.BiciRoute.Repositories;

import edu.eci.BiciRoute.Models.Bicicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IBicicleRepository extends MongoRepository<Bicicle, String> {
}
