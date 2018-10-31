package com.wq.springboot.service.impl;

import java.util.List;

import com.wq.springboot.entity.MyStudent;
import com.wq.springboot.mapper.MyStudentMapper;
import com.wq.springboot.service.IMyStudentService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("myStudentService")
@Transactional
public class MyStudentServiceImpl extends BaseServiceImpl<MyStudentMapper, MyStudent, Long> implements IMyStudentService {
    @SuppressWarnings("unchecked")
    @Override
    public List<String> getAllName(MyStudentMapper mapper) {
        return mapper.getAllName();
    }
}
