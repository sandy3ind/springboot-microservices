package com.sampleauthserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sampleauthserver.restclient.UserClient;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
    private UserClient userClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		UserDetails user = (UserDetails) userClient.getUserByPhone(username);
		if (user != null) {	
			user.getAuthorities();
            return user;
        }
        throw new UsernameNotFoundException(username);
	}

}
