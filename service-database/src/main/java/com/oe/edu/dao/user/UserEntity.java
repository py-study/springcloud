package com.oe.edu.dao.user;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;

import com.oe.edu.dao.role.RoleEntity;

@Entity
@Table(name="user")
public class UserEntity {
	
    @Id
    @Column(name="id")
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="active")
    private int active;
    @Column(name="email")
    private String email;
	@Column(name="password")
    private String password;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))	
	private Set<RoleEntity> roleEntities;
	
    public UserEntity() {}
    
    public UserEntity(String id, String name, int active, String email, String password, Set<RoleEntity> roles) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.email = email;
		this.password = password;
		this.roleEntities = roles;
	}
    
	public UserEntity(UserEntity user) {
		super();
		this.id = user.id;
		this.name = user.name;
		this.active = user.active;
		this.email = user.email;
		this.password = user.password;
		this.roleEntities = user.roleEntities;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleEntity> getRoleEntities() {
		return roleEntities;
	}

	public void setRoleEntities(Set<RoleEntity> roleEntities) {
		this.roleEntities = roleEntities;
	}

}
