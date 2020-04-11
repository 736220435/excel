package com.springboot.servie.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.dao.CarDao;
import com.springboot.entity.Car;
import com.springboot.servie.CarService;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public PageInfo<Car> carList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Car> cars = carDao.carList();
        return new PageInfo<>(cars);
    }

    @Override
    public Integer insertCarByExcel(MultipartFile multipartFile) {
        List<Car> carList = new ArrayList<>();
        try {
            // 创建都Excel工作簿文件的引用
            XSSFWorkbook sheets = new XSSFWorkbook(multipartFile.getInputStream());
            // 获取Excel工作表总数
            int numberOfSheets = sheets.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                XSSFSheet sheet = sheets.getSheetAt(i);
                for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
                    Car car = new Car();
                    for (int k = 1; k < sheet.getRow(j).getPhysicalNumberOfCells(); k++) {
                        DataFormatter dataFormatter = new DataFormatter();
                        String stringCellValue = dataFormatter.formatCellValue(sheet.getRow(j).getCell(k));
                        switch (k) {
                            case 1:
                                car.setName(stringCellValue);
                                break;
                            case 2:
                                car.setPrice(Integer.parseInt(stringCellValue));
                                break;
                            case 3:
                                car.setColour(stringCellValue);
                                break;
                            case 4:
                                car.setBrand(stringCellValue);
                                break;
                        }
                    }
                    carList.add(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carDao.insertCar(carList);
    }
}