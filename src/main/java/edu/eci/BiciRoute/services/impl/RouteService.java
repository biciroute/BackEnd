package edu.eci.BiciRoute.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
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
        route.getCommonRoute().set_id(ObjectId.get());
        System.out.println(route.toString());
        iRouteRepository.save(route);
    }

    @Override
    public List<CommonRoute> suggestRoute(CommonRoute commonRoute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(commonRoute.getHour());
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        System.out.println(hours);
        List<CommonRoute> routes = commonRouteRepository.findByPoint(commonRoute.getOrigin().get_id(),
                commonRoute.getDestination().get_id());
        List<CommonRoute> suggest = new ArrayList<>();
        for(CommonRoute commonRoute1 : routes){
            Calendar calendar1 = Calendar.getInstance();
            if(commonRoute1.getHour()!=null){
                calendar1.setTime(commonRoute.getHour());
                int minutes1 = calendar.get(Calendar.MINUTE);
                if(Math.abs(minutes1-minutes) <= 20){
                    suggest.add(commonRoute1);
                }
            }
        }
        return suggest;
    }

    @Override
    public List<Route> getRoutesByUser(String user_id) {
        List<Route> routes = iRouteRepository.findRoutesByUser(new ObjectId(user_id));
        return routes;
    }


}
