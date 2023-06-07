package br.ufrn.imd.progdistribuida.accountmanager.security;


import br.ufrn.imd.progdistribuida.accountmanager.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
	public String gerarToken(User user) {
		return JWT.create()
				.withIssuer("User")
				.withSubject(user.getUsername())
				.withClaim("id", user.getId())
				.withExpiresAt(LocalDateTime.now()
						.plusMinutes(10)
						.toInstant(ZoneOffset.of("-03:00"))
						
						).sign(Algorithm.HMAC512("Secreta"));
	}

	public Object getSubject(String token) {
		// TODO Auto-generated method stub
		return JWT.require(Algorithm.HMAC512("Secreta"))
				.withIssuer("User")
				.build().verify(token)
				.getSubject();
		
	}
}
