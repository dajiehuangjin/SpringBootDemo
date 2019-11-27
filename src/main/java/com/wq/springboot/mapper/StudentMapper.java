package com.wq.springboot.mapper;

import com.wq.springboot.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//测试用
public interface StudentMapper {
    @Select("SELECT * FROM student")
    List<Student> findAll();
}
