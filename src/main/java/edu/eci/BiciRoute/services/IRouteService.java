package edu.eci.BiciRoute.services;

import java.util.List;

import edu.eci.BiciRoute.Models.CommonRoute;
import edu.eci.BiciRoute.Models.Route;

public interface IRouteService {

    Route getRoute(String idRoute);

    void removeRoute(String userId);

    void updateRoute(Route user);

    void saveRoute(Route route);

    List<CommonRoute> suggestRoute(CommonRoute commonRoute); 

    List<Route> getRoutesByUser(String user_id);


}
