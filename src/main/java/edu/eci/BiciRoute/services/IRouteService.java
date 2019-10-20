package edu.eci.BiciRoute.services;

import edu.eci.BiciRoute.Models.Route;
import edu.eci.BiciRoute.Models.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface IRouteService {

    List<Route> getRouteList(String userId);

    Route getRoute(String idRoute);

    void removeRoute(String userId);

    void updateRoute(Route user);

    void saveRoute(Route route);
}
