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

import edu.eci.BiciRoute.Models.CommonRoute;
import edu.eci.BiciRoute.Models.Route;
import edu.eci.BiciRoute.services.IRouteService;


@RestController
@RequestMapping("v1/routes")
@CrossOrigin
public class RouteController {

    @Autowired
    private IRouteService iRouteService;

    @GetMapping(value="/user/{user_id}")
    public ResponseEntity<?> getRoutesbyUser(@PathVariable String user_id){
        try{
            System.out.println("buenas");
            return new ResponseEntity<>(iRouteService.getRoutesByUser(user_id),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("It is not possible bring all routes", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{routeId}")
    public ResponseEntity<?> getRoute(@PathVariable String routeId){
        try{
            return new ResponseEntity<>(iRouteService.getRoute(routeId),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("It is not possible bring all routes", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveRoute(@RequestBody Route route){
        try{
            if(route.getOrigin()==null || route.getDestination()==null){
                return new ResponseEntity<>("Must fill in origin, and destination", HttpStatus.BAD_REQUEST);
            }
            iRouteService.saveRoute(route);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Could not create route", HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateRoute(@RequestBody Route route){
        try{
            iRouteService.updateRoute(route);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Could not update route", HttpStatus.FORBIDDEN);
        }
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteRoute(@PathVariable String id){
        try{
            iRouteService.removeRoute(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Could not delete route", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(value="/suggest")
    public ResponseEntity<?> suggestRoute(@RequestBody CommonRoute commonRoute) {
        try{
            return new ResponseEntity<>(iRouteService.suggestRoute(commonRoute),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Could not suggest a Route", HttpStatus.FORBIDDEN);
        }
    }
    
    

}
