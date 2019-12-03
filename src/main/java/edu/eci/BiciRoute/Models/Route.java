package edu.eci.BiciRoute.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Route{
    @Id
    private ObjectId _id;
    @DBRef
    private Point origin;
    @DBRef
    private Point destination;
    @DBRef
    User user;
    @DBRef
    CommonRoute commonRoute;

    @Override
    public String toString() {
        return "Route [_id=" + _id + ", commonRoute=" + commonRoute + ", destination=" + destination + ", origin="
                + origin + ", user=" + user + "]";
    }
}