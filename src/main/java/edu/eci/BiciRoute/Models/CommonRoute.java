package edu.eci.BiciRoute.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class CommonRoute {
    @Id
    private ObjectId _id;
    @DBRef
    private Point origin;
    @DBRef
    private Point destination;
    @DBRef
    private User leaderRoute;
    private Date hour;
}