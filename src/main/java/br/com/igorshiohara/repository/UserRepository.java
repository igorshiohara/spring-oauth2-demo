package br.com.igorshiohara.repository;

import java.util.Optional;

import br.com.igorshiohara.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findOneByLogin(String login);
	
}
