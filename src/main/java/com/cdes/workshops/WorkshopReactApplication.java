package com.cdes.workshops;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;


@SpringBootApplication
@EntityScan(basePackageClasses = {WorkshopReactApplication.class, Jsr310JpaConverters.class})
public class WorkshopReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopReactApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean corsFilter(){
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept"));
		config.setAllowedMethods(Arrays.asList("POST", "GET", "DELETE", "PUT", "OPTIONS","PATCH"));
		config.setMaxAge(3600L);
		source.registerCorsConfiguration("/**", config);

		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;

	}

}
