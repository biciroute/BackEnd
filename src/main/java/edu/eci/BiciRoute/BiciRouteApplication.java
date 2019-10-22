package edu.eci.BiciRoute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import edu.eci.BiciRoute.Config.JwtFilter;

@SpringBootApplication
public class BiciRouteApplication {

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

}
