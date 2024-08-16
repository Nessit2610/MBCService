package com.ftec.MBCService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftec.MBCService.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
