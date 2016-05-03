package eu.baldarn.classifica.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import eu.baldarn.classifica.model.costants.Role;

//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
        .authorizeRequests()
            .antMatchers(
            		"/theme/**",
            		"/*"
            		).permitAll()
            .antMatchers("/admin/**").hasAuthority(Role.ROLE_ADMIN.getValue())
            .antMatchers("/user/**").hasAnyAuthority(Role.ROLE_USER.getValue(),Role.ROLE_ADMIN.getValue())
            .anyRequest().authenticated()
        .and()
        .formLogin()	
        	.loginPage("/login")
        	.loginProcessingUrl("/login")
            .permitAll()
        .and()
        .logout()
        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
            .permitAll()
     	.and()
        	.csrf();
		
	}
	
}	