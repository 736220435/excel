package com.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.Computer;
import com.springboot.servie.ComputerService;
import com.springboot.util.ResultVOUtils;
import com.springboot.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    @RequestMapping("/computerList")
    public ResultVO<Object> computerList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        PageInfo<List<Computer>> listPageInfo = computerService.computerList(pageNum, pageSize);
        if (listPageInfo.getList().size() > 0) {
            return ResultVOUtils.success(listPageInfo);
        }
        return ResultVOUtils.error("查询失败");
    }
}