package com.springboot.servie;

import com.springboot.entity.Computer;

import java.util.List;

public interface ComputerService {
    public List<Computer> computerList();

    public Integer insertComputer(List<Computer> computers);
}
