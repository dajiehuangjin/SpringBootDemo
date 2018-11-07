package com.wq.springboot.service.impl;

import org.springframework.stereotype.Service;

import com.wq.springboot.entity.AccUser;
import com.wq.springboot.service.IHAccUserService;
import com.wq.springboot.common.service.impl.HBaseServiceImpl;

import org.springframework.transaction.annotation.Transactional;

@Service("hAccUserService")
@Transactional//在service上面加上这个注解即可，或者在你需要事务的类上加这个注解
public class HAccUserServiceImpl extends HBaseServiceImpl<AccUser, Long> implements IHAccUserService {

}
