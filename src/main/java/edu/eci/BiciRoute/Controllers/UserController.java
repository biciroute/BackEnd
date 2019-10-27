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

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
            if(user.getEmail()==null || user.getPassword()==null || user.getFirstName()==null || user.getLastName()==null){
                return new ResponseEntity<>("Must fill in email, password, first name, and last name", HttpStatus.BAD_REQUEST);
            }
            User findUser = iUserService.getUserByEmail(user.getEmail());
            if(findUser!=null){
                return new ResponseEntity<>("This email has already been taken!", HttpStatus.CONFLICT);
            }
            User savedUser = iUserService.saveUser(user);
            String jwtToken = Jwts.builder().setSubject(user.getEmail()).claim("roles", "user").setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
            return new ResponseEntity<>(new Token(jwtToken, savedUser.getFirstName(), savedUser.get_id().toString()), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Could not create user", HttpStatus.FORBIDDEN);
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

    @PostMapping(value = "/login")
    public Token login(@RequestBody User login) throws ServletException {
        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Must fill in username and password");
        }
        String email = login.getEmail();
        String password = login.getPassword();

        User user = iUserService.getUserByEmail(email);
        if (user == null) {
            throw new ServletException("Invalid login. Please, check your email and password.");
        }
        String pwd = user.getPassword();
        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please, check your email and password.");
        }
        String jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        return new Token(jwtToken, user.getFirstName(), user.get_id().toString()); //THIS IS IMPORTANT!!. DO NOT REMOVE
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Data
    public class Token {
        String accessToken;
        String firstName; //This token is assigned to this user. THIS IS IMPORTANT!!. DO NOT REMOVE
        Object userId;
    }

}
