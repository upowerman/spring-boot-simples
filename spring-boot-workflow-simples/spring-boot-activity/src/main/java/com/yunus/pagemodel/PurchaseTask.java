package com.yunus.pagemodel;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PurchaseTask {

    private int bussinesskey;
    private String applyer;
    private String itemlist;
    private BigDecimal total;
    private Date applytime;
    private String taskid;
    private String taskname;
    private String processinstanceid;
    private String processdefid;


}
