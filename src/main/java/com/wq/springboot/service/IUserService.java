package com.wq.springboot.service;

import com.wq.springboot.entity.AcctUser;

import java.util.List;

public interface IUserService {
    AcctUser get(String id);

    List<AcctUser> findAll();

    void insert(AcctUser entity);

    void update(AcctUser entity);

    void delete(String id);

}
