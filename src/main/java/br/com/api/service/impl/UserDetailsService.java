package br.com.api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.api.entity.UserEntity;
import br.com.api.entity.UserProfile;
import br.com.api.repository.UserProfileRepository;
import br.com.api.repository.UserRepository;


@Service(value = "userService")
@Transactional(rollbackOn=Exception.class)
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> userEntityOpt = userRepository.findByLoginIgnoreCase(username);
		
		if( !userEntityOpt.isPresent() ){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new User(userEntityOpt.get().getLogin(), userEntityOpt.get().getSenha(), getAuthority(userEntityOpt.get().getId()));
	}

	private List<SimpleGrantedAuthority> getAuthority(Long userId) {
		List<UserProfile> listProfiles = userProfileRepository.findByUserId(userId);
		
		return listProfiles.stream()
				.map(profile -> new SimpleGrantedAuthority(profile.getProfile().getName()))
				.collect(Collectors.toList());
	}
}