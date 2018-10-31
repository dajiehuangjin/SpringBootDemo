package com.wq.springboot.service.impl;

import com.wq.springboot.entity.AccUser;
import com.wq.springboot.mapper.AccUserMapper;
import com.wq.springboot.service.IAccUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccUserServiceImpl implements IAccUserService {
    @Autowired
    private AccUserMapper accUserMapper;

    @Override
    public List<AccUser> getAccUserInfo() {
        return accUserMapper.findAllUserInfo();
    }

    @Override
    public void insert(AccUser accUser) {
        accUserMapper.addUserInfo(accUser);
    }

    @Override
    public void del(int id) {
        accUserMapper.delUserInfo(id);
    }

    @Override
    public void updateById(AccUser accUser) {
        accUserMapper.updateById(accUser);
    }
}
