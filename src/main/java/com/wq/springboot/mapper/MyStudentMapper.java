package com.wq.springboot.mapper;

import com.wq.springboot.common.mapper.BaseMapper;
import java.util.List;

public interface MyStudentMapper extends BaseMapper {
    @SuppressWarnings("rawtypes")
    List getAllName();
}
