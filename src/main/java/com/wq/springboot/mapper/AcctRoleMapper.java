package com.wq.springboot.mapper;

import com.wq.springboot.entity.AcctRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcctRoleMapper {
    AcctRole selectById(String id);

    List<AcctRole> list();
    int insert(AcctRole acctRole);


    int update(AcctRole acctRole);

    int delete(String id);
}
