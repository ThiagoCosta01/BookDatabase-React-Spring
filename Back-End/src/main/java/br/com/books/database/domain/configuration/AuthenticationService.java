package br.com.books.database.domain.configuration;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.books.database.domain.model.UserModel;
import br.com.books.database.dto.AuthenticationDto;

public interface AuthenticationService extends UserDetailsService{

	public String obterToken(AuthenticationDto authenticationDto);
	public String geraTokenJwt(UserModel userModel);
	public String validaToken(String token);
	
}
