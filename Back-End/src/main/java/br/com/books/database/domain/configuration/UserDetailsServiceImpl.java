package br.com.books.database.domain.configuration;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.books.database.domain.model.UserModel;
import br.com.books.database.domain.repository.UserRepository;
import br.com.books.database.dto.AuthenticationDto;

@Service
public class UserDetailsServiceImpl implements AuthenticationService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return userRepository.findByUserName(userName);
	
	}

	@Override
	public String obterToken(AuthenticationDto authenticationDto) {
		UserModel userModelInstance = userRepository.findByUserName(authenticationDto.userName());
		
		return geraTokenJwt(userModelInstance);
	}
	
	public String geraTokenJwt(UserModel userModel) {
		try {
			Algorithm algorithm = Algorithm.HMAC256("chave-secreta");
			
			return JWT.create()
					.withIssuer("books-database")
					.withSubject(userModel.getUsername())
					.withExpiresAt(geraDataExpiracao())
					.sign(algorithm);			
		}catch (Exception e) {
			throw new RuntimeException("Erro ao gerar o token: " + e.getMessage());
		}
	}
	
	private Instant geraDataExpiracao() {
		return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
	}
	
	//verifica token
}
