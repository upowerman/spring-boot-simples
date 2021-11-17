package com.yunus.pagemodel;

import lombok.Data;

import java.util.Date;

@Data
public class LeaveTask {
    /**
     * 主键
     */
    private int id;
    /**
     * 流程实例id
     */
    private String process_instance_id;
    private String user_id;
    private String start_time;
    private String end_time;
    private String leave_type;
    private String reason;
    private String apply_time;
    private String reality_start_time;
    private String reality_end_time;
    private String taskid;
    private String taskname;
    private String processinstanceid;
    private String processdefid;
    private Date taskcreatetime;

}
