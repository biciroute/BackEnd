package edu.eci.BiciRoute;

import edu.eci.BiciRoute.Models.CommonRoute;
import edu.eci.BiciRoute.Models.Point;
import edu.eci.BiciRoute.Repositories.ICommonRouteRepository;
import edu.eci.BiciRoute.services.IRouteService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import edu.eci.BiciRoute.Config.JwtFilter;

import java.util.Date;

@SpringBootApplication
public class BiciRouteApplication /*implements CommandLineRunner*/ {


	public static void main(String[] args) {
		SpringApplication.run(BiciRouteApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter( new JwtFilter() );
		registrationBean.addUrlPatterns( "/api/*" );

		return registrationBean;
	}


	/*
	@Autowired
	IRouteService iRouteService;

	@Autowired
	ICommonRouteRepository iCommonRouteRepository;

	@Override
	public void run(String... args) throws Exception {
		Point calle_100 =  new Point();
		calle_100.set_id(ObjectId.get());
		calle_100.setLatitude("4.623763");
		calle_100.setLongitude("-74.065523");
		Point calle_200 =  new Point();
		calle_200.set_id(ObjectId.get());
		calle_200.setLatitude("4.623763");
		calle_200.setLongitude("-76.065523");

		CommonRoute commonRoute = new CommonRoute(ObjectId.get(),calle_100,calle_200,null,new Date());
		iCommonRouteRepository.save(commonRoute);
	}*/

}
