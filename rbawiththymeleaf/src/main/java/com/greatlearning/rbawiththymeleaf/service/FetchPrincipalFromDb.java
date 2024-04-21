package com.greatlearning.rbawiththymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.rbawiththymeleaf.entity.User;
import com.greatlearning.rbawiththymeleaf.repository.UserRepository;

@Service
public class FetchPrincipalFromDb implements UserDetailsService
{
	@Autowired
	UserRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userrepo.findByUsername(username);
		
		if(user==null)
			throw new UsernameNotFoundException("Principal Does not Exist");
		
		return new GlMyUserDecorator(user);
	}

}
