package edu.eci.BiciRoute.Controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.BiciRoute.Models.Point;
import edu.eci.BiciRoute.Repositories.IPointRepository;

@RestController
@RequestMapping("v1/point")
public class PointController{

    @Autowired
    private IPointRepository repository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Point> getAllPoints() {
        return repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Point createPoint(@RequestBody Point point) {
        point.set_id(ObjectId.get());
        repository.save(point);
        return point;
    }
}