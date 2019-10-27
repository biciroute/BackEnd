package edu.eci.BiciRoute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import edu.eci.BiciRoute.Config.JwtFilter;

@SpringBootApplication
public class BiciRouteApplication /*implements CommandLineRunner*/   {


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

	/*@Autowired
	IPointService pointService;

	@Override
	public void run(String... args) throws Exception {
		Point calle_100 =  new Point();
		calle_100.set_id(ObjectId.get());
		calle_100.setLatitude("4.623763");
		calle_100.setLongitude("-74.065523");
		calle_100.setCommon(true);
		pointService.savePoint(calle_100);
	}*/

}
