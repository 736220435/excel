package com.springboot.servie.impl;

import com.springboot.entity.Computer;
import com.springboot.servie.ComputerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {
    @Override
    public List<Computer> computerList() {
        return null;
    }

    @Override
    public Integer insertComputer(List<Computer> computers) {
        return null;
    }
}
