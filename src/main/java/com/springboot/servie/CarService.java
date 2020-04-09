package com.springboot.servie;

import com.springboot.entity.Car;

import java.util.List;

public interface CarService {
    public List<Car> carList();

    public Integer insertCar(List<Car> cars);
}
