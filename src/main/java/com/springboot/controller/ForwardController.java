package com.springboot.controller;

import com.springboot.servie.ForwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForwardController {
    @Autowired
    private ForwardService forwardService;

    @RequestMapping("/forward")
    public String forward() {
        return "forward";
    }

    @RequestMapping("/insertForwardByExcel")
    public ModelAndView insertForwardByExcel(@RequestParam("file") MultipartFile multipartFile) {
        ModelAndView modelAndView = new ModelAndView("success");
        Integer integer = forwardService.insertForward(multipartFile);
        if (integer > 0) {
            modelAndView.addObject("msg", "通过Excel插入成功！");
            return modelAndView;
        }
        modelAndView.addObject("msg", "通过Excel插入失败！");
        return modelAndView;
    }
}
