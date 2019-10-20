package edu.eci.BiciRoute.Controllers;

import edu.eci.BiciRoute.Models.Route;
import edu.eci.BiciRoute.Models.User;
import edu.eci.BiciRoute.services.IRouteService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


@RestController
@RequestMapping("v1/route")
@CrossOrigin
public class RouteController {

    @Autowired
    private IRouteService iRouteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAllUser(@PathVariable String id){
        try{
            return new ResponseEntity<>(iRouteService.getRouteList(id),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("It is not posssible bring all users", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveRoute(@RequestBody Route route){
        try{
            iRouteService.saveRoute(route);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("You can not create user", HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateRoute(@RequestBody Route route){
        try{
            iRouteService.updateRoute(route);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("You can not update user", HttpStatus.FORBIDDEN);
        }
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteRoute(@PathVariable String id){
        try{
            iRouteService.removeRoute(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("You can not delete user", HttpStatus.FORBIDDEN);
        }
    }

}
