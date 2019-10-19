package edu.eci.BiciRoute.Repositories;

import edu.eci.BiciRoute.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRouteRepository extends MongoRepository<User, String> {
}
