package edu.eci.BiciRoute.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Point {
    @Id
    public ObjectId _id;

    public String latitude;
    public String longitude;

    public Point() {
    }

    public Point(ObjectId _id, String latitude, String longitude) {
        this._id = _id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    
}