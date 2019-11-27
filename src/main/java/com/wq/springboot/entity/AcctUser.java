package com.wq.springboot.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AcctUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String nick_name;
    private String telephone;
    private Date register_time;
    private List<AcctUserRole> acctUserRoles;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }


    public List<AcctUserRole> getAcctUserRoles() {
        return acctUserRoles;
    }

    public void setAcctUserRoles(List<AcctUserRole> acctUserRoles) {
        this.acctUserRoles = acctUserRoles;
    }

}
