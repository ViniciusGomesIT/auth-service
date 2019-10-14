package br.com.api.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.resource.AuthResource;

@RestController
@RequestMapping(value = "/auth")
public class AuthController implements AuthResource {

	@Override
	public Principal getCurrentLoggedInUser(Principal user) {
		return user;
	}
}
