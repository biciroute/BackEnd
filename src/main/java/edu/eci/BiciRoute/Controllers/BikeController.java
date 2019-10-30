package edu.eci.BiciRoute.Controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.BiciRoute.Models.Bicicle;
import edu.eci.BiciRoute.Models.User;
import edu.eci.BiciRoute.services.IBicicleService;
import edu.eci.BiciRoute.services.IUserService;

@RestController
@RequestMapping("v1/bike")
public class BikeController {

    @Autowired
    private IBicicleService bicicleService;

    @Autowired
    @Qualifier("userImplService")
    private IUserService userService;

    @PostMapping(value = ("/{user_id}"))
    public Bicicle createBike(@RequestBody Bicicle bicicle, @PathVariable String user_id) {
        //Guardar bicicleta
        bicicle.set_id(ObjectId.get());
        bicicleService.saveBicicle(bicicle);
        
        //Guardar referencia en el usuario
        User user =  userService.getUserBy_id(user_id);
        user.set_id(new ObjectId(user_id) );
        user.setBicicle(bicicle);
        userService.updateUser(user);
        return bicicle;
    }

    @PutMapping(value = ("/{user_id}"))
    public ResponseEntity<?> updateBicicle(@RequestBody Bicicle bicicle, @PathVariable String user_id) {
        if (bicicle.get_id() != null) {
            try{
                bicicleService.updateBicicle(bicicle);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch(Exception ex){
                return new ResponseEntity<>("Could not update bicycle",HttpStatus.FORBIDDEN);
            }
        } else {
            try{
                bicicleService.saveBicicle(bicicle);
                User user = userService.getUserBy_id(user_id);
                user.set_id(new ObjectId(user_id));
                user.setBicicle(bicicle);
                userService.updateUser(user);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch(Exception ex){
                return new ResponseEntity<>("Could not update bicycle",HttpStatus.FORBIDDEN);
            }
        }
    }
}