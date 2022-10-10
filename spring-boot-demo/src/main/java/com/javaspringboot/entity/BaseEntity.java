package com.javaspringboot.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity {
	@Id // tạo cột id và đánh dấu khóa chính
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id tự tăng
	private int id;
	
	@Column(name = "status")
	private int status;
}
