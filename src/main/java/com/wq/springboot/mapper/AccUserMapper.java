package com.wq.springboot.mapper;

import com.wq.springboot.entity.AccUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccUserMapper {

    List<AccUser> findAllUserInfo();
    int addUserInfo(AccUser user);
    int delUserInfo(int id);
    int updateById(AccUser user);
}
