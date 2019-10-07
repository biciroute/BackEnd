package edu.eci.BiciRoute.Controllers;


import edu.eci.BiciRoute.Models.User;
import edu.eci.BiciRoute.services.IUserService;
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
    public ResponseEntity<?> getAllUser(){
        try{
            return new ResponseEntity<>(iUserService.getUserList(),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("It is not posssible bring all users", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user){
        try{
            iUserService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("You can not create user", HttpStatus.FORBIDDEN);
        }
    }


}
