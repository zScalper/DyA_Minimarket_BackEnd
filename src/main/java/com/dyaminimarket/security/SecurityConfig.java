package com.dyaminimarket.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtFilter jwtFilter; // Inyectamos correctamente el filtro JWT

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors(Customizer.withDefaults()) // habilita CORS a nivel de seguridad
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/login").permitAll()
						.requestMatchers("/estados").permitAll().requestMatchers("/monedas").permitAll()
						.requestMatchers("/roles").permitAll().requestMatchers("/formas-pago/**").permitAll()
						.requestMatchers("/tipo-proveedor/**").permitAll().requestMatchers("/proveedores/**")
						.permitAll().requestMatchers("/categorias/**").permitAll().requestMatchers("/productos/**")
						.permitAll().requestMatchers("/unidades/**").permitAll()
						.requestMatchers("/detalle-cotizacion/**").permitAll()
						.requestMatchers("/detalle-requerimiento/**").permitAll().requestMatchers("/cotizaciones/**")
						.permitAll().requestMatchers("/requerimientos/**").permitAll().requestMatchers("/provincias/**")
						.permitAll().requestMatchers("/departamentos/**").permitAll().requestMatchers("/distritos/**")
						.permitAll().requestMatchers("/tiendas/**").permitAll().requestMatchers("/despachos/**")
						.permitAll().requestMatchers("/detalle-despachos/**").permitAll()
						.requestMatchers("/ordenes-compra/**").permitAll()
						// Acceso granular según método y autoridad
						.requestMatchers(HttpMethod.GET, "/usuarios/**").hasAnyAuthority("Administrador", "Logistica")
						.requestMatchers(HttpMethod.POST, "/usuarios").hasAuthority("Administrador")
						.requestMatchers(HttpMethod.PUT, "/usuarios/**").hasAuthority("Administrador")
						.requestMatchers(HttpMethod.DELETE, "/usuarios/**").hasAuthority("Administrador")

						// Cualquier otro endpoint protegido
						.anyRequest().authenticated())
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(
				List.of("http://localhost:4200", "https://jolly-rock-09b37551e.1.azurestaticapps.net"));
		configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(List.of("*"));
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
