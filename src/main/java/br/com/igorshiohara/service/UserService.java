package br.com.igorshiohara.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.igorshiohara.exception.InactiveUserException;
import br.com.igorshiohara.model.User;
import br.com.igorshiohara.repository.FakeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("usuarioService")
public class UserService implements UserDetailsService {

//	@Inject
//	private UserRepository userRepository;
	
	@Autowired
	private FakeUserRepository fakeRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        String lowercaseLogin = login.toLowerCase();
//        Optional<User> registeredUser = userRepository.findOneByLogin(lowercaseLogin);
        Optional<User> registeredUser = fakeRepository.userFake(lowercaseLogin);
        return registeredUser.map(user -> {
            if (!user.isActive()) {
                throw new InactiveUserException("User " + lowercaseLogin + " is inactive.");
            }
            List<GrantedAuthority> grantedProfiles = user.getProfiles().stream()
                    .map(profile -> new SimpleGrantedAuthority(profile.getName()))
                .collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(lowercaseLogin,
                user.getPassword(),
                grantedProfiles);
        }).orElseThrow(() -> new UsernameNotFoundException("Username " + lowercaseLogin + " not found."));
	}
	
//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//		Optional<User> user = fakeRepository.userFake(login);
//		if (!user.isPresent()) {
//			throw new UsernameNotFoundException("User " + login + " not found");
//		}
//		return new UserContext(user.get());
//	}

}
