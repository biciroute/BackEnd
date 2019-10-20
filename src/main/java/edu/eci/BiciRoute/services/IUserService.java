package edu.eci.BiciRoute.services;


import edu.eci.BiciRoute.Models.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface IUserService {

    List<User> getUserList();

    void removeUser(String userId);

    void updateUser(User user);

    void saveUser(User user);
}
