package edu.eci.BiciRoute.services.impl;

import edu.eci.BiciRoute.Models.User;
import edu.eci.BiciRoute.Repositories.IUserRepository;
import edu.eci.BiciRoute.services.IUserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "userImplService")
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public void removeUser(String email) {
        userRepository.removeUserByEmailEquals(email);
    }

    @Override
    public User updateUser(String email , User user) {
       return userRepository.updateUser(email,user);
    }

    @Override
    public void saveUser(User user) {
        user.set_id(ObjectId.get());
        userRepository.insert(user);
    }
}
