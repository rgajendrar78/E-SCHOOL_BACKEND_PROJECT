package com.in.eschool;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.in.eschool.model.Attempts;
import com.in.eschool.model.SecurityUser;
import com.in.eschool.repository.AttemptsRepository;
import com.in.eschool.repository.SecurityUserRepository;

@Component
public class AuthProvider implements AuthenticationProvider {
	private Logger logger=LoggerFactory.getLogger(AuthProvider.class);
	
	private static final int ATTEMPTS_LIMIT = 3;
	@Autowired
	private SecurityUserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AttemptsRepository attemptsRepository;
	@Autowired
	private SecurityUserRepository userRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		logger.info(" Authentication for username:{}",username);
		Optional<Attempts> userAttempts = attemptsRepository.findAttemptsByUsername(username);
		if (userAttempts.isPresent()) {
			Attempts attempts = userAttempts.get();
			attempts.setAttempts(0);
			attemptsRepository.save(attempts);
		}
		if(authentication.isAuthenticated()) {
			
		}
		
		return authentication;
	}

	private void processFailedAttempts(String username, SecurityUser SecurityUser) {
		Optional<Attempts> userAttempts = attemptsRepository.findAttemptsByUsername(username);
		if (userAttempts.isEmpty()) {
			Attempts attempts = new Attempts();
			attempts.setUsername(username);
			attempts.setAttempts(1);
			attemptsRepository.save(attempts);
		} else {
			Attempts attempts = userAttempts.get();
			attempts.setAttempts(attempts.getAttempts() + 1);
			attemptsRepository.save(attempts);

			if (attempts.getAttempts() + 1 > ATTEMPTS_LIMIT) {
				SecurityUser.setAccountNonLocked(false);
				userRepository.save(SecurityUser);
				throw new LockedException("Too many invalid attempts. Account is locked!!");
			}
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}