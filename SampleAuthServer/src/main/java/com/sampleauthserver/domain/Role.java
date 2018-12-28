package com.sampleauthserver.domain;

import com.sampleauthserver.util.Constant.RoleType;

public class Role {
	
	private int id;	
	private RoleType role;
	
	public Role () {}
	public Role(RoleType role) {
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RoleType getRole() {
		return role;
	}
	public void setRole(RoleType role) {
		this.role = role;
	}
}
