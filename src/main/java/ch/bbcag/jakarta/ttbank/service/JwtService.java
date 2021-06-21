package ch.bbcag.jakarta.ttbank.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.ejb.Stateless;
import java.util.Date;

@Stateless
public class JwtService {
	private final String ISSUER = "gameXchange";
	private final String SIGNING_KEY = "secret";

	public String generateJwt(String subject) {
		String token;
		try {
			Algorithm algorithm = Algorithm.HMAC256(SIGNING_KEY);
			token = JWT.create()
					.withIssuer(ISSUER)
					.withClaim("sub", subject)
					.withIssuedAt(new Date())
					.withExpiresAt(new Date(new Date().getTime() + 31154000000L))
					.sign(algorithm);
		} catch (JWTCreationException ex) {
			throw ex;
		}
		return token;
	}

	public DecodedJWT verifyToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(SIGNING_KEY);
			JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
			DecodedJWT jwt = verifier.verify(token);
			return jwt;
		} catch (JWTVerificationException exception) {
			throw exception;
		}
	}
}

