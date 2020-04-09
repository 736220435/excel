package com.springboot.util;

import com.springboot.vo.ResultVO;

public class ResultVOUtils {
    public static ResultVO<Object> success(Object object) {
        ResultVO<Object> objectResultVO = new ResultVO<>();
        objectResultVO.setCode(0);
        objectResultVO.setMsg("成功");
        objectResultVO.setData(object);
        return objectResultVO;
    }

    public static ResultVO<Object> success() {
        return success(null);
    }

    public static ResultVO<Object> error(String msg) {
        ResultVO<Object> objectResultVO = new ResultVO<>();
        objectResultVO.setCode(1);
        objectResultVO.setMsg(msg);
        return objectResultVO;
    }
}