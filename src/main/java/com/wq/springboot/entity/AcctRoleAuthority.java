package com.wq.springboot.entity;

public class AcctRoleAuthority {
    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getAuthority_id() {
        return authority_id;
    }

    public void setAuthority_id(String authority_id) {
        this.authority_id = authority_id;
    }

    public AcctAuthority getAcctAuthority() {
        return acctAuthority;
    }

    public void setAcctAuthority(AcctAuthority acctAuthority) {
        this.acctAuthority = acctAuthority;
    }

    private String role_id;
    private String authority_id;
    private AcctAuthority acctAuthority;
}
