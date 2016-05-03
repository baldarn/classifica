package eu.baldarn.classifica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.baldarn.classifica.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findById(Long id);
	User findByUsername(String username);
	List<User> findAllByOrderByPointsDesc();
	
}