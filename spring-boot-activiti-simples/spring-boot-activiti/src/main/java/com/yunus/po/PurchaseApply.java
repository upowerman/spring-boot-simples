package com.yunus.po;

import lombok.Data;
import org.activiti.engine.task.Task;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PurchaseApply {
	private int id;
	private String itemlist;
	private BigDecimal total;
	private Date applytime;
	private String applyer;
	private Task task;
	
}
