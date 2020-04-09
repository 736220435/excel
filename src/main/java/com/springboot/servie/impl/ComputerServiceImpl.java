package com.springboot.servie.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.dao.ComputerDao;
import com.springboot.entity.Computer;
import com.springboot.servie.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {
    @Autowired
    private ComputerDao computerDao;

    @Override
    public PageInfo<List<Computer>> computerList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo(computerDao.computerList());
    }

    @Override
    public Integer insertComputer(List<Computer> computers) {
        return null;
    }
}
