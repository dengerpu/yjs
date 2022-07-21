package com.ep.controller;

import com.ep.vo.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public ResultInfo test() {
        ResultInfo info = new ResultInfo();
        info.setStatus(200);
        info.setMessage("请求成功");
        return info;
    }
}
