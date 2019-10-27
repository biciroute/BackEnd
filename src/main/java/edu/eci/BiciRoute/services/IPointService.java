package edu.eci.BiciRoute.services;

import java.util.List;

import edu.eci.BiciRoute.Models.Point;

public interface IPointService {
    List<Point> getPointList();
    void savePoint(Point point);
}
