package com.javaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringboot.entity.Role;

// giao tiep voi DB: select, insert, update,...
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
