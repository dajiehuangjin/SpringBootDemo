package com.wq.springboot.service.impl;

import com.wq.springboot.entity.AccUser;
import com.wq.springboot.service.IJpaAccUserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaAccUserService")
@Transactional
public class JpaAccUserServiceImpl extends JpaBaseServiceImpl<AccUser, Long> implements IJpaAccUserService {

}
