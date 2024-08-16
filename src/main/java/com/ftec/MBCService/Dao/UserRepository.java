package com.ftec.MBCService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftec.MBCService.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User findByUsername(@Param("username") String username);

	//@Query("")
	public User findByEmail(@Param("email") String email);
}

