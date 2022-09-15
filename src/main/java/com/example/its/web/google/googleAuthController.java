package com.example.its.web.google;


import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.its.domain.auth.User;
import com.example.its.domain.auth.UserRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class googleAuthController {
	
	private final UserRepository userRepository;
	
	@GetMapping("/google")
	  public String index(@AuthenticationPrincipal OidcUser user, Model model) {

	    
//	    Optional<User> loginUser = userRepository.findByUsername(user.getEmail());
	    
//	    if(loginUser.isPresent()) {
//	    	return "index";
//	    }else {
//	    	return "/login";
//	    }
	    
	    return "index";
	    
	  }

}
