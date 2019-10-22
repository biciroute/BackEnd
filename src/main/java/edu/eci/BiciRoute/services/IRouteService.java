package edu.eci.BiciRoute.services;

import java.util.List;

import edu.eci.BiciRoute.Models.Route;

public interface IRouteService {

    List<Route> getRouteList(String userId);

    Route getRoute(String idRoute);

    void removeRoute(String userId);

    void updateRoute(Route user);

    void saveRoute(Route route);
}
