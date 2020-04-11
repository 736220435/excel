package com.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.Car;
import com.springboot.servie.CarService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/carList")
    public ModelAndView carList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView("car");
        PageInfo<Car> listPageInfo = carService.carList(pageNum, pageSize);
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

    @RequestMapping("/exportCarByExcel")
    public ModelAndView exportCarByExcel(HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("success");
        HSSFWorkbook workbook = carService.exportExcel();
        // 获取输出流
        OutputStream os = null;
        try {
            // 获取输出流
            os = response.getOutputStream();
            // 重置输出流
            response.reset();
            // 设定输出文件头
            response.setHeader("Content-disposition",
                    "attachment; filename=" + new String("car".getBytes("GB2312"), "8859_1") + ".xls");
            // 定义输出类型
            response.setContentType("application/msexcel");
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert os != null;
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}