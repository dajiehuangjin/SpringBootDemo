package com.wq.springboot.service.impl;

import com.wq.springboot.entity.AcctUser;
import com.wq.springboot.mapper.MyUserMapper;
import com.wq.springboot.service.IMyUserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("myUserService")
@Transactional
public class MyUserServiceImpl extends BaseServiceImpl<MyUserMapper, AcctUser, String> implements IMyUserService {

}
