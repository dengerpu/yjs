package com.ep.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageBean implements Serializable {

    private Long total;   //总记录数

    private Long totalPage;    //总页数

    private Object list;      //结果集

    private Long currentPage;    //当前页

    private Long pageSize;       //每页个数


}
