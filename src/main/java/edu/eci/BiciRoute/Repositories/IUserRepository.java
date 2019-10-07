package edu.eci.BiciRoute.Repositories;


import edu.eci.BiciRoute.Models.User;
import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IUserRepository extends MongoRepository<User, String> , IUserRepositoryU  {
    public List<User> findAll();
    public void removeUserByEmailEquals(String email);


}
