package com.springboot.servie;

import com.springboot.entity.Computer;

import java.util.List;

public interface ComputerService {
    public List<Computer> computerList(Integer pageNum,Integer pageSize);

    public Integer insertComputer(List<Computer> computers);
}
