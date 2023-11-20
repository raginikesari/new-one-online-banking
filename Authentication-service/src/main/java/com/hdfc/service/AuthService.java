package com.hdfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hdfc.constants.Constants;
import com.hdfc.dto.User;

@Component
public class AuthService {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private JwtService jwtService;
	
	// static final String USER_URL_MS="http://localhost:8877/user";

	public String saveUser(User user) {
		String response =null;
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User newUser = restTemplate.postForObject(Constants.USER_URL_MS+"/add", user, User.class);
			if(newUser!=null) {
				response = "User is registered successfully";
			}
		}catch(Exception ex) {
			response="User is not registered dut to an exception"+ex.getMessage();
		}
        return response;
    }
	
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}
	
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}
}