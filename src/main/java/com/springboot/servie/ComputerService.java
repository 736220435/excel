package com.springboot.servie;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.Computer;

import java.util.List;

public interface ComputerService {
    public PageInfo<List<Computer>> computerList(Integer pageNum, Integer pageSize);

    public Integer insertComputer(List<Computer> computers);
}
