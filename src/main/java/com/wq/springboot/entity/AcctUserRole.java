package com.wq.springboot.entity;

public class AcctUserRole {
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public AcctRole getAcctRole() {
        return acctRole;
    }

    public void setAcctRole(AcctRole acctRole) {
        this.acctRole = acctRole;
    }

    private String user_id;
    private String role_id;
    private AcctRole acctRole;
}
