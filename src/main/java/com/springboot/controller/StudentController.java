package com.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.Student;
import com.springboot.servie.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/studentList")
    public ModelAndView studentList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView("student");
        PageInfo<List<Student>> listPageInfo = studentService.studentList(pageNum, pageSize);
        if (listPageInfo.getList().size() > 0) {
            modelAndView.addObject("listPageInfo", listPageInfo);
            return modelAndView;
        }
        modelAndView.addObject("msg", "查询失败！");
        return modelAndView;
    }
}