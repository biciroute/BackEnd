package edu.eci.BiciRoute.Repositories.impl;

import edu.eci.BiciRoute.Repositories.IUserRepositoryU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import edu.eci.BiciRoute.Models.*;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

public class UserRepositoryImpl implements IUserRepositoryU {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User updateUser(String email, User user) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(email));
        Update update = new Update();
        update.set("name", user.getName());
        mongoTemplate.update(User.class).matching(query).apply(update).first();
        return  null;
    }
}
