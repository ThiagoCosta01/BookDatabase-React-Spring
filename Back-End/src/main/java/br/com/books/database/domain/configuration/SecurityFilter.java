package br.com.books.database.domain.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.books.database.domain.model.UserModel;
import br.com.books.database.domain.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = extraiTokenHeader(request);
		
		if(token!=null) {
			String login = authenticationService.validaToken(token);
			UserModel userModel = userRepository.findByUserName(login);
		}
		
	}

	
	//extrai token header
	public String extraiTokenHeader(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization"); 
		
		if(authHeader == null) {
			return null;
		}
		
		if(authHeader.split(" ")[0].equals("Bearer")) return authHeader.split(" ")[1];
		return null;
	}
}
