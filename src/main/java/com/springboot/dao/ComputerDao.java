package com.springboot.dao;

import com.springboot.entity.Computer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ComputerDao {
    /**
     * 查询全部电脑信息
     *
     * @return
     */
    public List<Computer> computerList();

    /**
     * 批量插入电脑信息
     *
     * @param computers
     * @return
     */
    public Integer insertComputer(List<Computer> computers);
}