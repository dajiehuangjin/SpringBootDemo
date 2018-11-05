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
    private IHAccUserService hAccUserService;

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
        List<AccUser> users = hAccUserService.get("id", "desc");
        CallResult cr = new CallResult(true);
        cr.setRows(users);
        return cr;
    }
    
    @RequestMapping(value="/add_h_user/{userName}", method = RequestMethod.GET)
    public String addHUser(ModelMap model, @PathVariable String userName) {
        AccUser user = new AccUser();
        user.setName(userName);
        hAccUserService.save(user);
        return "add success: "+userName;
    }

    @RequestMapping(value="/del_h_user/{userId}", method=RequestMethod.GET)
    public String delHUser(ModelMap model, @PathVariable Long userId) {
        hAccUserService.deleteById(userId);
        return "delete success: "+userId;
        //  HQL语句中表名应该是ORM映射的类名
        // int ret = h_accUserService.executeSql("delete from AccUser ac where ac.id="+userId.toString());
        // return "delete success: "+ret;
    }

    @RequestMapping(value="/update_h_user/{userName}/id/{userId}", method = RequestMethod.GET)
    public String updatebyHId(ModelMap model, @PathVariable String userName, @PathVariable Long userId) {
        AccUser user = new AccUser();
        user.setId(userId);
        user.setName(userName);
        hAccUserService.update(user);
        return "update success: "+userId+"=>"+userName;
    }
}
