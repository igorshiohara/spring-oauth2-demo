package br.com.igorshiohara.repository;

import java.util.Optional;

import br.com.igorshiohara.model.Profile;
import br.com.igorshiohara.model.User;
import org.springframework.stereotype.Service;

@Service
public class FakeUserRepositoryImpl implements FakeUserRepository {
	
	@Override
	public Optional<User> userFake(String login) {
		
		Profile userProfile = new Profile();
		userProfile.setName("USER");
		
		Profile adminProfile = new Profile();
		adminProfile.setName("ADMIN");
		
		if (login.equalsIgnoreCase("admin")) {
			User u = new User();
			u.setActive(true);
			u.setEmail("admin@admin.com");
			u.setId(99L);
			u.setLogin("admin");
			u.setName("Administrator");
			u.setPassword("admin");
			u.getProfiles().add(userProfile);
			u.getProfiles().add(adminProfile);
			
			return Optional.of(u);
		} 
		if (login.equalsIgnoreCase("user")) {
			User u = new User();
			u.setActive(true);
			u.setEmail("user@user.com");
			u.setId(99L);
			u.setLogin("user");
			u.setName("Common User");
			u.setPassword("user");
			u.getProfiles().add(userProfile);
			
			return Optional.of(u);
		}
		return Optional.empty();
	}
	
	

}
