package com.yunus.po;

import lombok.Data;
import org.activiti.engine.task.Task;

import java.io.Serializable;

@Data
public class LeaveApply implements Serializable{
	int id;
	String process_instance_id;
	String user_id;
	String start_time;
	String end_time;
	String leave_type;
	String reason;
	String apply_time;
	String reality_start_time;
	String reality_end_time;
	Task task;
	
}
