package com.javaspringboot.service;

import java.util.List;

import com.javaspringboot.dto.RoleDTO;

public interface IRoleService {
	// lấy toàn bộ danh sách từ bảng role trong DB
	List<RoleDTO> getAllList();
	
	// xem thông tin chi tiết
	RoleDTO getDetails(int roleId);
	
	// thêm mới role
	RoleDTO createNew(RoleDTO roleDTO);
	
	// cập nhật role
	RoleDTO update(RoleDTO roleDTO);
	
	// xóa role theo id
	boolean delete(int roleId);
}
