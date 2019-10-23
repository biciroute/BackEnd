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
    public void removeUser(String userId) {
        userRepository.deleteById(userId);
    }



    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void saveUser(User user) {
        user.set_id(ObjectId.get());
        userRepository.insert(user);
    }

    @Override
    public User getUserByEmal(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserBy_id(String _id) {
        return userRepository.findBy_id(_id);
    }
}
