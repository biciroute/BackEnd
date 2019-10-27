package edu.eci.BiciRoute.Models;

import edu.eci.BiciRoute.Models.utils.TypeUser;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User{
    @Id
    private ObjectId _id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    @DBRef
    private TypeUser typeUser;
    private int amountKilometers;
    private int burntCalories;
    @DBRef
    private Bicicle bicicle;
    /*@DBRef
    private List<Route> routes;*/

}