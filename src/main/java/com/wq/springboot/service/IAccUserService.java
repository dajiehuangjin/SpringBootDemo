package com.wq.springboot.service;

import com.wq.springboot.entity.AccUser;

import java.util.List;

public interface IAccUserService {
    List<AccUser> getAccUserInfo();
    void insert(AccUser accUser);
    void del(int id);
    void updateById(AccUser accUser);
}
