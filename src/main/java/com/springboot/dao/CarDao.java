package com.springboot.dao;

import com.springboot.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CarDao {
    /**
     * 查询全部的车信息
     *
     * @return
     */
    public List<Car> carList();

    /**
     * 批量添加车信息
     *
     * @param cars
     * @return
     */
    public Integer insertCar(List<Car> cars);
}