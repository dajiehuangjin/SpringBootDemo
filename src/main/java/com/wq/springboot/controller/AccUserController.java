package com.wq.springboot.controller;

import com.wq.springboot.common.json.CallResult;
import com.wq.springboot.entity.AccUser;
import com.wq.springboot.service.IAccUserService;
import com.wq.springboot.service.IJpaAccUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acc_user")
public class AccUserController {
    @Autowired
    private IAccUserService accUserService;

    @Autowired
    private IJpaAccUserService jpaAccUserService;

    @RequestMapping("/users")
    public CallResult getUserInfo() {
        List<AccUser> users = accUserService.getAccUserInfo();
        CallResult cr = new CallResult(true);
        cr.setRows(users);
        return cr;
    }

    @RequestMapping(value="/add_user/{userName}", method = RequestMethod.GET)
    public String addUser(ModelMap model, @PathVariable String userName) {
        AccUser user = new AccUser();
        user.setName(userName);
        accUserService.insert(user);
        return "add success: "+userName;
    }

    @RequestMapping(value="/del_user/{userId}", method = RequestMethod.GET)
    public String delUser(ModelMap model, @PathVariable int userId) {
        accUserService.del(userId);
        return "delete success: "+userId;
    }

    @RequestMapping(value="/update_user/{userName}/id/{userId}", method = RequestMethod.GET)
    public String updatebyId(ModelMap model, @PathVariable String userName, @PathVariable long userId) {
        AccUser user = new AccUser();
        user.setId(userId);
        user.setName(userName);
        accUserService.updateById(user);
        return "update success: "+userId+"=>"+userName;
    }

    @RequestMapping("/h_users")
    public CallResult get_h_users() {
        // List<AccUser> users = jpaAccUserService.getAll(new Sort(Sort.Direction.DESC, "id"));
        Page<AccUser> users = jpaAccUserService.getByPage(0, 2, new Sort(Sort.Direction.DESC, "id"));
        CallResult cr = new CallResult(true);
        cr.setRows(users);
        return cr;
    }
    
    @RequestMapping(value="/add_h_user/{userName}", method = RequestMethod.GET)
    public String addHUser(ModelMap model, @PathVariable String userName) {
        AccUser user = new AccUser();
        user.setName(userName);
        jpaAccUserService.save(user);
        return "add success: "+userName;
    }

    @RequestMapping(value="/del_h_user/{userId}", method=RequestMethod.GET)
    public String delHUser(ModelMap model, @PathVariable Long userId) {
        // jpaAccUserService.deleteById(userId);
        // return "delete success: "+userId;
        // 必须要使用原生sql语句
        int ret = jpaAccUserService.executeSql("delete ac from acc_user ac where ac.id="+userId.toString());
        return "delete success: "+ret;
    }

    @RequestMapping(value="/update_h_user/{userName}/id/{userId}", method = RequestMethod.GET)
    public String updatebyHId(ModelMap model, @PathVariable String userName, @PathVariable Long userId) {
        AccUser user = new AccUser();
        user.setId(userId);
        user.setName(userName);
        jpaAccUserService.save(user);
        return "update success: "+userId+"=>"+userName;
    }
}
