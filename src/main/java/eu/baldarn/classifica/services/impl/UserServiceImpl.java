package eu.baldarn.classifica.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.baldarn.classifica.model.User;
import eu.baldarn.classifica.repository.UserRepository;
import eu.baldarn.classifica.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> search(String username, String email){
		return null;
	}
	
}
