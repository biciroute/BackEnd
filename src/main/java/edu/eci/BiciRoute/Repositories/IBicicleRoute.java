package edu.eci.BiciRoute.Repositories;

import edu.eci.BiciRoute.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IBicicleRoute extends MongoRepository<User, String> {
}
