package com.springboot.dao;

import com.springboot.entity.Forward;
import com.springboot.entity.ForwardResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ForwardResultDao {
    Integer insertForwardResult(ForwardResult forwardResult);
}
