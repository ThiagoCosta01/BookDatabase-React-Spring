package br.com.books.database.domain.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//Filter
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf( csrf -> csrf.disable())
				.authorizeHttpRequests( authorizeConfig -> {
							authorizeConfig.requestMatchers(HttpMethod.POST, "/api/user/register").permitAll();
							authorizeConfig.requestMatchers("/logout").permitAll();	
							authorizeConfig.requestMatchers("/api/book").permitAll();
							authorizeConfig.requestMatchers(HttpMethod.POST, "/api/user/login").permitAll();
							authorizeConfig.requestMatchers(HttpMethod.GET, "/api/user/login").permitAll();
							authorizeConfig.anyRequest().authenticated();
						})
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();		
	}
	
	  @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
	            throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
