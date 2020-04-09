package com.springboot.servie;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.Car;

import java.util.List;

public interface CarService {
    public PageInfo<List<Car>> carList(Integer pageNum, Integer pageSize);

    public Integer insertCar(List<Car> cars);
}
