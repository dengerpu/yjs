package com.ep.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Menus {

    private Integer id;

    private String authName;

    private String path;

    private Integer order;

    private Integer pid;

    private List<Menus> children;
}
