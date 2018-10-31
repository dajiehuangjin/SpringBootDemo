package com.wq.springboot.entity;

import java.util.List;

public class AcctRole{

	private String id;
	private String name;
	private List<AcctRoleAuthority> acctRoleAuthorities;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AcctRoleAuthority> getAcctRoleAuthorities() {
		return acctRoleAuthorities;
	}

	public void SetAcctRoleAuthorities(List<AcctRoleAuthority> acctRoleAuthorities) {
		this.acctRoleAuthorities = acctRoleAuthorities;
	}
}
