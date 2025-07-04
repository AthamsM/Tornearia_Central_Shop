package br.com.torneariacentralshop.api.auth;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	//private final SecretKey secret = Jwts.SIG.HS256.key().build();
	private final String key = "JhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6IkF0aGFtc0BnbWFpbC5jb20iLCJwYXNzd29yZCI6IjEyMzQ1Njc4In0.olI7raOOW0l1psFLtPDYbBZbPCyapqSRmJAIgMVMs2I";
	//Keys.hmacShaKeyFor(key.getBytes(StandarCharsets.UTF_8));
	private final SecretKey secret = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
	
	public String generateToken(User user) {
		return Jwts
				.builder()
				.subject(user.getEmail())
				.claim("name", user.getName())
				.claim("id", user.getId())
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 86400000))
				.signWith(secret)
				.compact();
	}
	
	public String extractEmail(String token) {
		return Jwts
				.parser()
				.verifyWith(secret)
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	public boolean isValid(String token, UserDetails user) {
		return extractEmail(token).equals(user.getUsername());
	}
	
}
