package eu.baldarn.classifica.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import eu.baldarn.classifica.model.User;
import eu.baldarn.classifica.model.costants.Role;
import eu.baldarn.classifica.repository.UserRepository;

//@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class AuthenticationSecurity extends GlobalAuthenticationConfigurerAdapter {
	
	@Autowired
	private DatabaseUserDetailsService users;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();			
		auth.userDetailsService(users).passwordEncoder(encoder);
//		auth.userDetailsService(users);
		
		if(userRepository.count() == 0){
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword(encoder.encode("admin"));
			admin.getRoles().add(Role.ROLE_ADMIN);
			userRepository.save(admin);
			
			User user = new User();
			user.setUsername("user");
			user.setPassword(encoder.encode("user"));
			user.getRoles().add(Role.ROLE_USER);
			userRepository.save(user);
		}
		
	}
	
}