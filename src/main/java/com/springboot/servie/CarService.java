package com.springboot.servie;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.Car;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CarService {
    PageInfo<Car> carList(Integer pageNum, Integer pageSize);

    Integer insertCarByExcel(MultipartFile multipartFile);

    HSSFWorkbook exportExcel();
}