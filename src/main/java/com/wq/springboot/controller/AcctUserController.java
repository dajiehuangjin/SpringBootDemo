package com.wq.springboot.controller;

import com.wq.springboot.entity.AcctRole;
import com.wq.springboot.mapper.AcctRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acct_user")
public class AcctUserController {

    @Autowired
    private AcctRoleMapper acctRoleMapper;

    @GetMapping("/roles")
    public List<AcctRole> role_list(){
        List<AcctRole> acctRoles = acctRoleMapper.list();
        return acctRoles;
    }

    @GetMapping("/role/{id}")
    public AcctRole role_selectById(@PathVariable("id")String id){
        AcctRole acctRole = acctRoleMapper.selectById(id);
        return acctRole;
    }

    @GetMapping("/role/{id}/delete")
    public String role_delete(@PathVariable String id){
        int result = acctRoleMapper.delete(id);
        if(result == 1)
            return "delete success!";
        return "delete fail!";
    }
}
