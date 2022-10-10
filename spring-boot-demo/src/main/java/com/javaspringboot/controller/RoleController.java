package com.javaspringboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javaspringboot.dto.RoleDTO;
import com.javaspringboot.service.IRoleService;

@Controller
public class RoleController {
	@Autowired
	private IRoleService roleService;

	@GetMapping(value = "/role/list")
	public String viewRoleListPage(Model model) {
		model.addAttribute("roleList", roleService.getAllList());
		return "role/list";
	}

	// hiển thị trang thêm mới hoặc trang chỉnh sửa vai trò
	@GetMapping(value = "/role/createOrUpdate")
	public String showCreateOfUpdateView(Model model, @RequestParam(name = "role-id", required = false) Integer roleId) {
		if (roleId == null) {
			model.addAttribute("roleDTO", new RoleDTO());
			return "role/create";
		} else {
			model.addAttribute("roleDTO", new RoleDTO());
			model.addAttribute("roleDetails", roleService.getDetails(roleId));
			return "role/update";
		}
	}

	// thêm mới hoặc cập nhật
	@PostMapping(value = "/role/createOrUpdate")
	public String save(@Valid @ModelAttribute("roleDTO") RoleDTO roleDTO, BindingResult bindingResult,
			RedirectAttributes model) {
		int getRoleId = roleDTO.getId();

		// nếu id = 0 thì đang thực hiện create new
		if (getRoleId == 0) {
			if (bindingResult.hasErrors()) {
				return "role/create";
			}

			try {
				if (roleService.createNew(roleDTO) != null) {
					model.addFlashAttribute("message", "Thêm mới thành công!");
				}
			} catch (Exception ex) {
				model.addFlashAttribute("error", "Thêm mới thất bại!");
			}
		} else { // nếu id khác 0 thì đang thực hiện update
			if (bindingResult.hasErrors()) {
				return "role/update";
			}

			try {
				if (roleService.update(roleDTO) != null) {
					model.addFlashAttribute("message", "Cập nhật thành công!");
				}
			} catch (Exception ex) {
				model.addFlashAttribute("error", "Cập nhật thất bại!");
			}
		}

		return "redirect:/role/list";
	}
	
	@GetMapping(value = "/role/delete")
	public String delete(RedirectAttributes model, @RequestParam(name = "role-id") int roleId) {
		try {
			if (roleService.delete(roleId)) {
				model.addFlashAttribute("message", "Xóa thành công!");
			}
		} catch (Exception ex) {
			model.addFlashAttribute("error", "Xóa thất bại!");
		}
		model.addFlashAttribute("roleList", roleService.getAllList());
		return "redirect:/role/list";
	}
}
