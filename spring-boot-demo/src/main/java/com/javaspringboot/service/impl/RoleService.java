package com.javaspringboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringboot.converter.RoleConverter;
import com.javaspringboot.dto.RoleDTO;
import com.javaspringboot.entity.Role;
import com.javaspringboot.repository.RoleRepository;
import com.javaspringboot.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	// hỗ trợ RoleService sử dụng các method của RoleRepository
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private RoleConverter roleConverter;

	@Override
	public List<RoleDTO> getAllList() {
		// khai báo danh sách role (dto) sẽ lấy ra
		List<RoleDTO> roleList = new ArrayList<>();
		
		// lấy danh sách role từ DB (entity)
		List<Role> getEntityList = roleRepo.findAll();
		
		// chuyển đổi entity thành dto
		for (Role role : getEntityList) {
			roleList.add(roleConverter.toDTO(role));
		}
		
		return roleList;
	}

	@Override
	public RoleDTO getDetails(int roleId) {
		// lấy ra thông tin của role theo id từ DB
		Role roleEntity = roleRepo.findById(roleId).get();
		
		// chuyển đổi dữ liệu từ entity sang dto (để có thể dùng được bên controller)
		RoleDTO roleDTO = roleConverter.toDTO(roleEntity);
		
		return roleDTO;
	}

	@Override
	public RoleDTO createNew(RoleDTO roleDTO) {
		Role roleEntity = new Role();
		
		// chuyển đổi dữ liệu từ roleDTO sang roleEntity
		roleEntity = roleConverter.toEntity(roleDTO);
		
		// lưu dữ liệu vào DB
		roleRepo.save(roleEntity);
		
		return roleConverter.toDTO(roleEntity);
	}

	@Override
	public RoleDTO update(RoleDTO roleDTO) {
		// lấy ra thông tin dữ liệu CŨ của role
		Role roleEntity = roleRepo.findById(roleDTO.getId()).get();
		
		// cập nhật dữ liệu cũ (roleEntity) bằng dữ liệu mới (roleDTO)
		roleEntity = roleConverter.toEntity(roleDTO, roleEntity);
		
		// tiến hành lưu
		roleRepo.save(roleEntity);
		
		return roleConverter.toDTO(roleEntity);
	}

	@Override
	public boolean delete(int roleId) {
		Role roleEntity = roleRepo.findById(roleId).get();
		
		if (roleEntity != null) {
			roleRepo.delete(roleEntity);
			return true;
		}
		
		return false;
	}

}
