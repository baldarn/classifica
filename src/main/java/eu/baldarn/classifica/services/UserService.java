package eu.baldarn.classifica.services;

import java.util.List;

import org.springframework.stereotype.Service;

import eu.baldarn.classifica.model.User;

@Service
public interface UserService {
	
	public List<User> search(String username, String email);
	
}
