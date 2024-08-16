package com.ftec.MBCService.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ftec.MBCService.Dao.RoleRepository;
import com.ftec.MBCService.Dao.UserRepository;
import com.ftec.MBCService.Entity.User;

public class UserServiceImpl implements UserService {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User authenticate(String username, String password) {
		User us = new User();
		us = userRepository.findByUsername(username);
		if(us != null && us.getPassword().equals(password)) {
			return us;
		}
		else {return null;}
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
