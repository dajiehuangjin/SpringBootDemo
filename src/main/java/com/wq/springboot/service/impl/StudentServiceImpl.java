package com.wq.springboot.service.impl;

import com.wq.springboot.entity.MyStudent;
import com.wq.springboot.mapper.MyStudentMapper;
//import com.wq.springboot.mapper.UserMapper;
import com.wq.springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements IStudentService {
    //使用通用的BaseMapper
    @Autowired
    private MyStudentMapper studentMapper;

    @Override
    public MyStudent get(Long id) {
        return (MyStudent) studentMapper.getById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MyStudent> findAll() {
        return studentMapper.getAll();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MyStudent> findAllByOrder(String orderBy) {
        if(orderBy != null && !orderBy.isEmpty()) {
            return studentMapper.getAllByOrder(orderBy);
        } else {
            return studentMapper.getAll();
        }
    }

    @Override
    public void insert(MyStudent entity) {
        studentMapper.insert(entity);
    }

    @Override
    public void update(MyStudent entity) {
        studentMapper.update(entity);
    }

    @Override
    public void delete(Long id) {
        studentMapper.delete(id);
    }
}
