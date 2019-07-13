package com.yunus.helloworld;


import org.activiti.engine.*;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.impl.form.DateFormType;
import org.activiti.engine.impl.form.StringFormType;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class DemoMain {


    public static void main(String[] args) throws ParseException {


        // 创建流程引擎

        ProcessEngine engine = createProcessEngine();

        // 部署流程定义文件

        ProcessDefinition processDefinition = deployProcessDefinition(engine);

        // 启动运行流程

        ProcessInstance processInstance = runProcess(engine, processDefinition);

        // 处理流程任务

        Scanner scanner = new Scanner(System.in);

        while (processInstance != null && !processInstance.isEnded()) {

            TaskService taskService = engine.getTaskService();
            List<Task> list = taskService.createTaskQuery().list();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(String.format("当前流程任务：%s ", list.get(i).getName()));
                FormService formService = engine.getFormService();
                TaskFormData taskFormData = formService.getTaskFormData(list.get(i).getId());
                List<FormProperty> formProperties = taskFormData.getFormProperties();
                Map<String, Object> variables = new HashMap<>();
                for (FormProperty formProperty : formProperties) {
                    String in = null;
                    if (StringFormType.class.isInstance(formProperty.getType())) {
                        System.out.println("请输入？," + formProperty.getName());
                        in = scanner.nextLine();
                        variables.put(formProperty.getId(), in);
                    } else if (DateFormType.class.isInstance(formProperty.getType())) {
                        System.out.println("请输入：" + formProperty.getName() + " 格式为：yyyy-MM-dd");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        in = scanner.nextLine();
                        Date parse = sdf.parse(in);
                        variables.put(formProperty.getId(), parse);
                    } else {
                        System.out.println("类型不支持");
                    }
                }
                taskService.complete(list.get(i).getId(), variables);
                processInstance = engine.getRuntimeService()
                        .createProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult();
            }
        }

    }

    private static ProcessInstance runProcess(ProcessEngine engine, ProcessDefinition processDefinition) {
        RuntimeService runtimeService = engine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());
        System.out.println(String.format("启动流程 %s", processInstance.getProcessDefinitionKey()));
        return processInstance;
    }

    private static ProcessDefinition deployProcessDefinition(ProcessEngine engine) {
        RepositoryService repositoryService = engine.getRepositoryService();
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        deploymentBuilder.addClasspathResource("process/leave.bpmn20.xml");
        Deployment deploy = deploymentBuilder.deploy();
        String deployId = deploy.getId();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployId)
                .singleResult();
        System.out.println(String.format("流程定义文件=%s,流程定义id=%s", processDefinition.getName(), processDefinition.getId()));
        return processDefinition;
    }

    private static ProcessEngine createProcessEngine() {
        ProcessEngineConfiguration engineConfiguration = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration();
        ProcessEngine engine = engineConfiguration.buildProcessEngine();
        String name = engine.getName();
        String version = engine.VERSION;
        System.out.println(String.format("流程引擎名称为%s,版本为%s", name, version));
        return engine;
    }
}
