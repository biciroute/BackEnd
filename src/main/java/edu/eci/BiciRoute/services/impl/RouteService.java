package edu.eci.BiciRoute.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.BiciRoute.Models.Route;
import edu.eci.BiciRoute.Repositories.IRouteRepository;
import edu.eci.BiciRoute.services.IRouteService;

@Component
public class RouteService implements IRouteService {

    @Autowired
    IRouteRepository iRouteRepository;

    @Override
    public List<Route> getRouteList(String id) {
        return iRouteRepository.findAllByUsersContains(id);
    }

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
        iRouteRepository.save(route);
    }
}
