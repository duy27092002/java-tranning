package com.javaspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

// tạo ra phương thức khởi tạo không tham số
@NoArgsConstructor

// tạo ra tất cả các phương thức khởi tạo có tham số
@AllArgsConstructor
public class BaseDTO {
	private int id;
	
	private int status;
}
