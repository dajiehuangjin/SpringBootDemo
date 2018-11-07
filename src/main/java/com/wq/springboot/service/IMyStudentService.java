package com.wq.springboot.service;

import java.util.List;

import com.wq.springboot.entity.MyStudent;
import com.wq.springboot.mapper.MyStudentMapper;
import com.wq.springboot.common.service.BaseService;

public interface IMyStudentService extends BaseService<MyStudentMapper, MyStudent, Long> {
    List<String> getAllName(MyStudentMapper mapper);
}
