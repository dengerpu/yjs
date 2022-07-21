package com.ep.vo;

import lombok.Data;

/***
 * 用于封装后端给前端返回的信息
 */
@Data
public class ResultInfo {

    private int status;           //状态码

    private String message;      //错误信息

    private Object data;         //后端返回结果数据对象
}
