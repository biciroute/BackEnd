package edu.eci.BiciRoute.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.BiciRoute.Models.Point;
import edu.eci.BiciRoute.Repositories.IPointRepository;
import edu.eci.BiciRoute.services.IPointService;

@Component
public class PointService implements IPointService {

    @Autowired
    IPointRepository iPointRepository;

    @Override
    public List<Point> getPointList() {
        return iPointRepository.findAll();
    }

    @Override
    public void savePoint(Point point) {
        iPointRepository.save(point);
    }

    @Override
    public List<Point> getAllCommonRoutes() {
        return iPointRepository.findByCommonIsTrue();
    }



}
