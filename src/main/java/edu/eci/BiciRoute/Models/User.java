package edu.eci.BiciRoute.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User{
    @Id
    public ObjectId _id;

    public String email;
    public String name;

    public User() {
    }

    public User(ObjectId _id, String email, String name) {
        this._id = _id;
        this.email = email;
        this.name = name;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}