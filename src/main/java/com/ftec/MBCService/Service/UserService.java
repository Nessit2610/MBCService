package com.ftec.MBCService.Service;

import com.ftec.MBCService.Entity.User;

public interface UserService {
	public User findByUsername(String username);
	public User authenticate(String username, String password);
	public User findByEmail(String email);
}
