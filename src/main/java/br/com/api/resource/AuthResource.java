package br.com.api.resource;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;

public interface AuthResource {
	
    @RequestMapping("/user")
    Principal getCurrentLoggedInUser(Principal user);
}
