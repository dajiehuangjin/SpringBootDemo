package com.wq.springboot.controller;

import com.wq.springboot.common.json.CallResult;
import com.wq.springboot.entity.AccUser;
import com.wq.springboot.service.IAccUserService;
import com.wq.springboot.service.IHAccUserService;

import org.springframework.beans.factory.annotation.Autowired;
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
    private IHAccUserService h_accUserService;

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
        return "success: "+userName;
    }

    @RequestMapping(value="/del_user/{userId}", method = RequestMethod.GET)
    public String delUser(ModelMap model, @PathVariable int userId) {
        accUserService.del(userId);
        return "success: "+userId;
    }

    @RequestMapping(value="/update_user/{userName}/id/{userId}", method = RequestMethod.GET)
    public String updatebyId(ModelMap model, @PathVariable String userName, @PathVariable long userId) {
        AccUser user = new AccUser();
        user.setId(userId);
        user.setName(userName);
        accUserService.updateById(user);
        return "success: "+userId+"=>"+userName;
    }

    @RequestMapping("/h_users")
    public CallResult get_h_users() {
        List<AccUser> users = h_accUserService.get("id", "desc");
        CallResult cr = new CallResult(true);
        cr.setRows(users);
        return cr;
    }

}
