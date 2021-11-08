package com.mapa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class MapaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapaApplication.class, args);
	}

}
