package com.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.Car;
import com.springboot.servie.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/carList")
    public ModelAndView carList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView("car");
        PageInfo<List<Car>> listPageInfo = carService.carList(pageNum, pageSize);
        if (listPageInfo.getList().size() > 0) {
            modelAndView.addObject("listPageInfo", listPageInfo);
            return modelAndView;
        }
        modelAndView.addObject("msg", "查询失败！");
        return modelAndView;
    }

    @RequestMapping("/insertCarByExcel")
    public ModelAndView insertCarByExcel(@RequestParam("file") MultipartFile multipartFile) {
        ModelAndView modelAndView = new ModelAndView("success");
        Integer integer = carService.insertCarByExcel(multipartFile);
        if (integer > 0) {
            modelAndView.addObject("msg", "通过Excel插入成功！");
            return modelAndView;
        }
        modelAndView.addObject("msg", "通过Excel插入失败！");
        return modelAndView;
    }
}