package br.com.api.service;

import java.util.List;

import br.com.api.entity.UserProfile;

public interface UserProfileService {

	List<UserProfile> findByUserId(Long userId);
}
