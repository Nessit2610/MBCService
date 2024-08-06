package com.mbcservice.MBCService.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mbcservice.MBCService.Entity.User;


public interface UserService extends UserDetailsService {
	public User findByUsername(String username);
	public void save(User user);
}
