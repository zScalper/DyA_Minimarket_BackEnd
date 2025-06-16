package com.dyaminimarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DyAMinimarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(DyAMinimarketApplication.class, args);
		/*
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword1 = "carlospass123"; // Reemplaza esto con tu contraseña real
        String rawPassword2 = "mariapass123"; // Reemplaza esto con tu contraseña real
        String hashedPassword1 = encoder.encode(rawPassword1);
        String hashedPassword2 = encoder.encode(rawPassword2);
        System.out.println("Contraseña encriptada 1: " + hashedPassword1);
        System.out.println("Contraseña encriptada 2: " + hashedPassword2);
        */
	}

}
