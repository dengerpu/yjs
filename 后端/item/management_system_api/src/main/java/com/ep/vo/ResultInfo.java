package com.ep.vo;

import com.ep.utils.ReturnCode;
import lombok.Data;

/***
 * 用于封装后端给前端返回的信息
 */
@Data
public class ResultInfo {

    private int status;           //状态码

    private String message;      //错误信息

    private Object data;         //后端返回结果数据对象

    private long timestamp ;

    public ResultInfo() {
        this.timestamp = System.currentTimeMillis();
    }

    public static  ResultInfo success(Object data) {
        ResultInfo info = new ResultInfo();
        info.setStatus(ReturnCode.S200.getCode());
        info.setMessage(ReturnCode.S200.getMessage());
        info.setData(data);
        return info;
    }
    public static ResultInfo success(int code, String message, Object data) {
        ResultInfo info = new ResultInfo();
        info.setStatus(code);
        info.setMessage(message);
        info.setData(data);
        return info;
    }

    public static ResultInfo fail(int code, String message) {
        ResultInfo info = new ResultInfo();
        info.setStatus(code);
        info.setMessage(message);
        return info;
    }
}
