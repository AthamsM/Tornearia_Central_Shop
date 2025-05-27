package br.com.torneariacentralshop.api.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.torneariacentralshop.api.entities.User;
import br.com.torneariacentralshop.api.repository.UserRepository;


@Service
public class UserDatailsServiceImpl implements UserDetailsService{

	private final UserRepository repository;
	
	public UserDatailsServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
		return user;
	}


}
