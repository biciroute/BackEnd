package edu.eci.BiciRoute.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Point {
    @Id
    private ObjectId _id;
    private String latitude;
    private String longitude;
    private boolean common;

    @Override
    public String toString() {
        return "Point [_id=" + _id + ", common=" + common + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }

    

}