package com.example.swaggerapp.security;


import com.example.swaggerapp.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.Set;


@Component
public class JwtTokenProvider {

    @Autowired
    UserDetailsService userDetailsService;

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.validity}")
    private long validity;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @PostConstruct
    protected void init(){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String createToken(String username, Set<Role> roles){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);

        Date date_now = new Date();
        Date validity_time = new Date(date_now.getTime() + validity);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(date_now)
                .setExpiration(validity_time)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validityToken(String token){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        if(claimsJws.getBody().getExpiration().before(new Date())){
            return false;
        }
        return true;
    }

    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUser(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getUser(String token) {
        return
                Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
}
