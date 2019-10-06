package edu.eci.BiciRoute.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Route{
    @Id
    public ObjectId _id;

    private Point origin;
    private Point destination;
    private Point commonOrigin;
    private Point commonDestination;

    public Route() {
    }

    public Route(ObjectId _id, Point origin, Point destination, Point commonOrigin, Point commonDestination) {
        this._id = _id;
        this.origin = origin;
        this.destination = destination;
        this.commonOrigin = commonOrigin;
        this.commonDestination = commonDestination;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

    public Point getCommonOrigin() {
        return commonOrigin;
    }

    public void setCommonOrigin(Point commonOrigin) {
        this.commonOrigin = commonOrigin;
    }

    public Point getCommonDestination() {
        return commonDestination;
    }

    public void setCommonDestination(Point commonDestination) {
        this.commonDestination = commonDestination;
    }

    
    
}