package edu.eci.BiciRoute.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Route{
    @Id
    private ObjectId _id;
    private Point origin;
    private Point destination;
    private Point commonOrigin;
    private Point commonDestination;
    private List<ObjectId> users;
    private ObjectId leaderRoute;
}