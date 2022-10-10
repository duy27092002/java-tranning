package com.javaspringboot.converter;

import org.springframework.stereotype.Component;

import com.javaspringboot.dto.RoleDTO;
import com.javaspringboot.entity.Role;

@Component
public class RoleConverter {
	
	// chuyển đổi entity thành dto
	public RoleDTO toDTO(Role role) {
		RoleDTO dto = new RoleDTO();
		dto.setId(role.getId());
		dto.setName(role.getName());
		dto.setStatus(role.getStatus());
		return dto;
	}
	
	// chuyển đổi dto thành entity
	public Role toEntity(RoleDTO dto) {
		Role entity = new Role();
		entity.setName(dto.getName().trim());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	
	// sử dụng cho chức năng update
	public Role toEntity(RoleDTO roleDTO, Role roleEntity) {
		roleEntity.setName(roleDTO.getName().trim());
		roleEntity.setStatus(roleDTO.getStatus());
		return roleEntity;
	}
}
