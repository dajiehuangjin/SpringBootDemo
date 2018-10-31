package com.wq.springboot.service.impl;

import com.wq.springboot.entity.AcctUser;
import com.wq.springboot.mapper.MyUserMapper;
//import com.wq.springboot.mapper.UserMapper;
import com.wq.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    /*
    // 使用UserMapper就可以了
    @Autowired
    private UserMapper userMapper;

    @Override
    public AcctUser get(String id) {
        return (AcctUser) userMapper.get(id);
    }

    @Override
    public List<AcctUser> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void persist(AcctUser entity) {
        userMapper.persist(entity);
    }

    @Override
    public String save(AcctUser entity) {
        return (String) userMapper.save(entity);
    }

    @Override
    public void saveOrUpdate(AcctUser entity) {
        userMapper.saveOrUpdate(entity);
    }

    @Override
    public void delete(String id) {
        userMapper.delete(id);
    }

    @Override
    public void flush() {
        userMapper.flush();
    }
    */

    //使用通用的BaseMapper
    @Autowired
    private MyUserMapper userMapper;

    @Override
    public AcctUser get(String id) {
        return (AcctUser) userMapper.getById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AcctUser> findAll() {
        return userMapper.getAll();
    }


    @Override
    public void insert(AcctUser entity) {
        userMapper.insert(entity);
    }

    @Override
    public void update(AcctUser entity) {
        userMapper.update(entity);
    }

    @Override
    public void delete(String id) {
        userMapper.delete(id);
    }

}
