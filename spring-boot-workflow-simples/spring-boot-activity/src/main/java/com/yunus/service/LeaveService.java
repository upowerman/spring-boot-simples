package com.yunus.service;

import com.yunus.po.LeaveApply;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;
import java.util.Map;


public interface LeaveService {
    ProcessInstance startWorkflow(LeaveApply apply, String userid, Map<String, Object> variables);

    List<LeaveApply> getpagedepttask(String userid, int firstrow, int rowcount);

    int getalldepttask(String userid);

    LeaveApply getleave(int id);

    List<LeaveApply> getpagehrtask(String userid, int firstrow, int rowcount);

    int getallhrtask(String userid);

    List<LeaveApply> getpageXJtask(String userid, int firstrow, int rowcount);

    int getallXJtask(String userid);

    List<LeaveApply> getpageupdateapplytask(String userid, int firstrow, int rowcount);

    int getallupdateapplytask(String userid);

    void completereportback(String taskid, String realstart_time, String realend_time);

    void updatecomplete(String taskid, LeaveApply leave, String reappply);

    List<String> getHighLightedFlows(ProcessDefinitionEntity deployedProcessDefinition, List<HistoricActivityInstance> historicActivityInstances);
}
