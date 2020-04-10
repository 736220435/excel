package com.springboot.servie;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.Car;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CarService {
    public PageInfo<List<Car>> carList(Integer pageNum, Integer pageSize);

    public Integer insertCarByExcel(MultipartFile multipartFile);
}