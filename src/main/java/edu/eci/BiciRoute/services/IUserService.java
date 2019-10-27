package edu.eci.BiciRoute.services;


import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.BiciRoute.Models.User;

@Service
public interface IUserService {

    List<User> getUserList();

    void removeUser(String userId);

    void updateUser(User user);

    User saveUser(User user);

    User getUserByEmail(String email);

    User getUserBy_id(String _id);
}
