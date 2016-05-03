package eu.baldarn.classifica.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import eu.baldarn.classifica.model.User;
import eu.baldarn.classifica.model.costants.Role;

public class DatabaseUserDetails implements UserDetails {

	User user;

	public DatabaseUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			SimpleGrantedAuthority auth = new SimpleGrantedAuthority(
					role.getValue());
			authList.add(auth);
		}

		return authList;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		if(user != null)
			return user.isActive();
		return false;
	}

	@Override
	public String getPassword() {
		if (user != null) {
			System.out.println("controllo password: " + user.getPassword());
			return user.getPassword();
		} else {
			return null;
		}
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	public User getUser() {
		return user;
	}
}
