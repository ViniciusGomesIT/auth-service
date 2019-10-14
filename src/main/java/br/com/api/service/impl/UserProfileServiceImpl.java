package br.com.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.entity.UserProfile;
import br.com.api.repository.UserProfileRepository;
import br.com.api.service.UserProfileService;


@Service
@Transactional(rollbackFor=Exception.class)
public class UserProfileServiceImpl  implements UserProfileService {
	
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public List<UserProfile> findByUserId(Long userId) {
		return userProfileRepository.findByUserId(userId);
	}
}