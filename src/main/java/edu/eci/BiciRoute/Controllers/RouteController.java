package edu.eci.BiciRoute.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.BiciRoute.Models.Route;
import edu.eci.BiciRoute.services.IRouteService;


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
