package com.oe.edu.dao.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleEntity {

    @Id
	@Column(name="id")
	private int id;
	@Column(name="rolevalue")
	private String rolevalue;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return rolevalue;
	}
	public void setRole(String role) {
		this.rolevalue = role;
	}
	
	
	public RoleEntity() {
		// TODO Auto-generated constructor stub
	}
	public RoleEntity(int id, String role) {
		super();
		this.id = id;
		this.rolevalue = role;
	}
	
	
}
