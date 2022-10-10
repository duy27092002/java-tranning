package com.javaspringboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role extends BaseEntity {
	@Column(name = "name")
	private String name;
	
	@OneToOne(mappedBy = "role", cascade = CascadeType.ALL)
	private User user;
}
