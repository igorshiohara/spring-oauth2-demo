package br.com.igorshiohara.repository;

import br.com.igorshiohara.model.User;

import java.util.Optional;

public interface FakeUserRepository {
	
	Optional<User> userFake(String login);

}
