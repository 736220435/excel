package com.springboot.servie.impl;

import com.springboot.entity.Car;
import com.springboot.servie.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> carList() {
        return null;
    }

    @Override
    public Integer insertCar(List<Car> cars) {
        return null;
    }
}
