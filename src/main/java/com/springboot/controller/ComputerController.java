package com.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.Computer;
import com.springboot.servie.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    @RequestMapping("/computerList")
    public ModelAndView computerList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView("computer");
        PageInfo<List<Computer>> listPageInfo = computerService.computerList(pageNum, pageSize);
        if (listPageInfo.getList().size() > 0) {
            modelAndView.addObject("listPageInfo", listPageInfo);
            return modelAndView;
        }
        modelAndView.addObject("msg", "查询失败！");
        return modelAndView;
    }
}