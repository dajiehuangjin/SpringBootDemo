package com.wq.springboot.service.impl;

import org.springframework.stereotype.Service;

import com.wq.springboot.entity.AccUser;
import com.wq.springboot.service.IHAccUserService;

@Service
public class HAccUserServiceImpl extends HBaseServiceImpl<AccUser, Long> implements IHAccUserService {

}
