package com.example.loginwithjwt.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtils {

	private String SECRET = "VASUDEV";
//	** ---- Token validates here ---- **

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		Claims claim = extractAllClaims(token);
		return claimResolver.apply(claim);
	}

	public Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
	}

	public boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public boolean isTokenValid(String token, UserDetails userDetail) {
		String username = userDetail.getUsername();
		return (username.equals(extractUsername(token)) && !isTokenExpired(token));
	}
//  ** ---- Token generates here ---- **

	public String generateToken(String username, String role) {
		Map<String, Object> obj = new HashMap<>();
		obj.put("role", role);
		return createToken(obj, username);
	}

	private String createToken(Map<String, Object> obj, String username) {
		// TODO Auto-generated method stub
		return Jwts.builder().setClaims(obj).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
				.signWith(SignatureAlgorithm.HS256, SECRET).compact();
	}

}
