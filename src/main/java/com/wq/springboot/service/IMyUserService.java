package com.wq.springboot.service;

import com.wq.springboot.entity.AcctUser;
import com.wq.springboot.mapper.MyUserMapper;
import com.wq.springboot.common.service.BaseService;

public interface IMyUserService extends BaseService<MyUserMapper, AcctUser, String> {
}
