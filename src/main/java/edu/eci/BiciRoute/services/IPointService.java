package edu.eci.BiciRoute.services;

import edu.eci.BiciRoute.Models.Point;
import edu.eci.BiciRoute.Models.User;

import java.util.List;

public interface IPointService {
    List<Point> getPointList();
}
