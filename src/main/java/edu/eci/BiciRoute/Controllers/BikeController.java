package edu.eci.BiciRoute.Controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
}