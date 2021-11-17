package com.yunus.pagemodel;

import lombok.Data;
import org.activiti.engine.repository.ProcessDefinition;

@Data
public class Process {
    private String id;
    private String DeploymentId;
    private String name;
    /**
     * 流程定义的资源的路径 （根据流程定义获取）
     */
    private String ResourceName;
    private String key;
    /**
     * 流程定义 png 图片路径  （根据流程定义获取）
     */
    private String diagramresourcename;

    /**
     * 根据流程定义 构建 Process
     *
     * @param processDefinition 流程定义
     * @return
     */
    public static Process builder(ProcessDefinition processDefinition) {
        Process process = new Process();
        process.setDeploymentId(processDefinition.getDeploymentId());
        process.setId(processDefinition.getId());
        process.setKey(processDefinition.getKey());
        process.setName(processDefinition.getName());
        process.setResourceName(processDefinition.getResourceName());
        process.setDiagramresourcename(processDefinition.getDiagramResourceName());
        return process;
    }

}
