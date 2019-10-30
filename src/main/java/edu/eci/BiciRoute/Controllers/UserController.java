package edu.eci.BiciRoute.Controllers;

import edu.eci.BiciRoute.Models.User;
import edu.eci.BiciRoute.services.IUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import javax.servlet.ServletException;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@RestController
@RequestMapping("v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    @Qualifier("userImplService")
    private IUserService iUserService;

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        try {
            return new ResponseEntity<>(iUserService.getUserList(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("It is not possible to bring all users", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(iUserService.getUserBy_id(id),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Could not delete user", HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        try {
            iUserService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Could not update user", HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        try {
            iUserService.removeUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Could not delete user", HttpStatus.FORBIDDEN);
        }
    }

}
