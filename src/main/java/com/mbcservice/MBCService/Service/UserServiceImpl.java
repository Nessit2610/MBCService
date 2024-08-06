package com.mbcservice.MBCService.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mbcservice.MBCService.Dao.RoleRepository;
import com.mbcservice.MBCService.Dao.UserRepository;
import com.mbcservice.MBCService.Entity.Role;
import com.mbcservice.MBCService.Entity.User;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
//	@PostConstruct
//	public void insertUser() {
//		User user1 = new User();
//		user1.setUsername("tien");
//		user1.setPassword("$2a$12$VHpzbozIs7zapsm7eQpoxuYFKmU7T39snGzoj/ildSMr6WmDFdVe6");
//		user1.setEnable(true);
//		Role role1 = new Role();
//		role1.setName("ROLE_ADMIN");
//		Collection<Role> roles = new ArrayList<>();
//		roles.add(role1);
//		user1.setRoles(roles);
//		userRepository.save(user1);
//	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid Username or Password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), rolesToAuthorities(user.getRoles()));
	}
	
	// java lamda get roles
	private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
	}
	
	@Override
	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

}
