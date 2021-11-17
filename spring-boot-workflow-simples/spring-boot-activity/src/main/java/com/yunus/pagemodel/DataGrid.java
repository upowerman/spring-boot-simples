package com.yunus.pagemodel;

import lombok.Data;

import java.util.List;

@Data
public class DataGrid<T> {


    private int current;//当前页面号
    private int rowCount;//每页行数
    private int total;//总行数
    private List<T> rows;



}
