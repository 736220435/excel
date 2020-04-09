package com.springboot.servie.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.dao.CarDao;
import com.springboot.entity.Car;
import com.springboot.servie.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> carList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return carDao.carList();
    }

    @Override
    public Integer insertCar(List<Car> cars) {
        return null;
    }
}