package br.com.books.database.domain.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	//Filter
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(
						authorizeConfig -> {
							authorizeConfig.requestMatchers("/api/user/register").permitAll();
							authorizeConfig.requestMatchers("/logout").permitAll();
							
							authorizeConfig.anyRequest().authenticated();
						})
				
				.build();
				
				
		
	}
	
	
	
}