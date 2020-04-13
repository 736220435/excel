package com.springboot.dao;

import com.springboot.entity.Forward;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ForwardDao {
    Integer insertForward(Forward forward);
}