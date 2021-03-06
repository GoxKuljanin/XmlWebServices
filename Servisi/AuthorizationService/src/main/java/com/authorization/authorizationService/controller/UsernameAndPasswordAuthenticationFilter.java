package com.authorization.authorizationService.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.authorization.authorizationService.config.JwtConfig;
import com.authorization.authorizationService.dto.UserDTO;
import com.authorization.authorizationService.model.Logovan;
import com.authorization.authorizationService.model.User;
import com.authorization.authorizationService.model.UserCredentials;
import com.authorization.authorizationService.repository.UserDetailRepository;
import com.authorization.authorizationService.service.UserDetailServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Controller
public class UsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	
	@Autowired
	UserDetailServiceImpl userService;
	
	@Autowired
	UserDetailRepository userRepo;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtConfig jwtConfig;
	@Autowired
	private BCryptPasswordEncoder encoder;

	protected final static Logger logger = LoggerFactory.getLogger(UsernameAndPasswordAuthenticationFilter.class);
	
	
	public UsernameAndPasswordAuthenticationFilter(AuthenticationManager authManager, JwtConfig jwtConfig) {
		this.authManager = authManager;
		this.jwtConfig = jwtConfig;

		this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/signin", "POST"));
	}
	
	@PostMapping("/login")
	public ResponseEntity<Logovan> prijava(@RequestBody UserDTO dto){
		logger.info("Login");
		return new ResponseEntity<Logovan>(signin(dto.getUsername(), dto.getPassword()), HttpStatus.OK);
	}



	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			
			// Taking credientials from request 
			UserCredentials creds = new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);

			//Creating authetntication object that has credidentials and which is used in authenticationManager for validation
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword(), Collections.emptyList());
			return authManager.authenticate(authToken);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * Metoda, koja u slucaju uspesne autentifikacije, generise token
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		Long now = System.currentTimeMillis();
		String token = Jwts.builder()
			.setSubject(auth.getName())
			.claim("authorities", auth.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
			.setIssuedAt(new Date(now))
			.setExpiration(new Date(now + jwtConfig.getExpiration() * 1000))  // in milliseconds
			.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
			.compact();

		// postavljanje tokena u header odgovora 
		response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix() + token);
	}
	
	
	@PostMapping("/registerKorisnik")
	public ResponseEntity<User> saveKorisnik(@RequestBody UserDTO korisnik){
		logger.info("Registrovanje novog korisnika");
		return new ResponseEntity<User>(userRepo.save(korisnik), HttpStatus.OK);
	}
	
	
	
	private Logovan signin(String username, String password) {
	
			Logovan loggedUser = new Logovan();
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());

			User user=userRepo.findByUsername(username);
			System.out.println();
			System.out.println(user.getPassword()+password);
			System.out.println();
			System.out.println( "Enkodirana"+encoder.encode("12345678"));
			System.out.println();
			System.out.println(user.getPassword().equals(encoder.encode(password)));
			Authentication authentication = authManager.authenticate(authToken);

			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			Long now = System.currentTimeMillis();
			String token = Jwts.builder()
				.setSubject(authentication.getName())
				.claim("authorities", authentication.getAuthorities().stream()
					.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(now))
				.setExpiration(new Date(now + jwtConfig.getExpiration() * 1000))  // in milliseconds
				.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
				.compact();
			logger.info("setovanje tokena");
			loggedUser.setToken(token);
			loggedUser.setUsername(username);
			loggedUser.setUserId(user.getId());
			loggedUser.setRoles(user.getRoles().get(0).getName());
			loggedUser.setNalogAktivan(user.isNalogAktivan());
			if(!userService.loadUserByUsername(username).isEnabled())
				return null;
			
			return loggedUser;

		}
		
	
	@Override
	@Autowired
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
	    super.setAuthenticationManager(authenticationManager);
	}
}