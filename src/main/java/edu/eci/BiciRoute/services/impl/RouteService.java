package edu.eci.BiciRoute.services.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.BiciRoute.Models.CommonRoute;
import edu.eci.BiciRoute.Models.Route;
import edu.eci.BiciRoute.Repositories.ICommonRouteRepository;
import edu.eci.BiciRoute.Repositories.IPointRepository;
import edu.eci.BiciRoute.Repositories.IRouteRepository;
import edu.eci.BiciRoute.services.IRouteService;

@Component
public class RouteService implements IRouteService {

    @Autowired
    IRouteRepository iRouteRepository;

    @Autowired
    IPointRepository pointRepository;

    @Autowired
    ICommonRouteRepository commonRouteRepository;

    @Override
    public Route getRoute(String idRoute) {
        return iRouteRepository.findBy_id(idRoute);
    }

    @Override
    public void removeRoute(String routeId) {
        iRouteRepository.deleteById(routeId);
    }

    @Override
    public void updateRoute(Route route) {
        iRouteRepository.save(route);
    }

    @Override
    public void saveRoute(Route route) {
        route.getDestination().set_id(ObjectId.get());
        route.getOrigin().set_id(ObjectId.get());

        pointRepository.save(route.getDestination());
        pointRepository.save(route.getOrigin());

        route.set_id(ObjectId.get());
        iRouteRepository.save(route);
    }

    @Override
    public List<CommonRoute> suggestRoute(CommonRoute commonRoute) {
        List<CommonRoute> routes = commonRouteRepository.findByPoint(commonRoute.getOrigin().get_id(),
                commonRoute.getDestination().get_id());
        return routes;
    }

    @Override
    public List<Route> getRoutesByUser(String user_id) {
        List<Route> routes = iRouteRepository.findRoutesByUser(new ObjectId(user_id));
        return routes;
    }


}
