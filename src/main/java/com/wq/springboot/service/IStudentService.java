package com.wq.springboot.service;

import com.wq.springboot.entity.MyStudent;

import java.util.List;

public interface IStudentService {
    MyStudent get(Long id);

    List<MyStudent> findAll();
    List<MyStudent> findAllByOrder(String orderBy);


    void insert(MyStudent entity);

    void update(MyStudent entity);

    void delete(Long id);
}
