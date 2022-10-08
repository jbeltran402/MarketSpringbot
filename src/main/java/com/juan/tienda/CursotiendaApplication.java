package com.juan.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.juan.tienda.persistence.mapper.ProductMapper"})
public class CursotiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursotiendaApplication.class, args);
	}
}
