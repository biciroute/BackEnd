package edu.eci.BiciRoute.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User{
    @Id
    private ObjectId _id;
    private String email;
    private String name;
    private TypeUser typeUser;
    private int amountKilometers;
    private int burntCalories;
    private Bicicle bicicle;
}