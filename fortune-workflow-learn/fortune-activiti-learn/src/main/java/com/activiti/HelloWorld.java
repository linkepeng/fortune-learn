package com.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

public class HelloWorld {
	
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	/** 部署流程图	**/
	@Test
	public void deploymentProcessDefinition() {
		Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的service
			.createDeployment()//创建一个部署对象
			.name("helloworld入门程序")
			.addClasspathResource("diagrams/helloworld.png")//从classpath的资源文件记载，一次只能价值一个文件
			.addClasspathResource("diagrams/helloworld.bpmn")//从classpath的资源文件记载，一次只能价值一个文件
			.deploy();//部署完成以后，返回一个部署对象
		
		System.out.println("部署ID :" + deployment.getId());
		System.out.println("部署名称 :" + deployment.getName());
	}
	
	/** 启动流程实例 **/
	@Test
	public void startProcessInstance() {
		String processDefinitionKey ="helloworld";
		ProcessInstance processInstance = processEngine.getRuntimeService()//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中的id属性
			.startProcessInstanceByKey(processDefinitionKey);
		
		System.out.println("流程ID:" + processInstance.getId());//流程id
		System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());//流程定义id
	}
	
	/**查询当前人的个人任务查询*/
	@Test
	public void findMyPersonalTask() {
		String assignee = "张三";
		List<Task> listTask = processEngine.getTaskService() //与正在执行的任务管理相关的service
			.createTaskQuery()//创建查询任务对象
			.taskAssignee(assignee)//指定个人任务查询，指定办理人
			.list();
		if(!CollectionUtils.isEmpty(listTask)) {
			/*listTask.forEach(task->{
				System.out.println("任务id："+task.getId());
				System.out.println("任务名称"+task.getName());
				System.out.println("任务创建时间："+task.getCreateTime());
				System.out.println("任务的办理人："+task.getAssignee());
				System.out.println("流程对象ID："+task.getProcessInstanceId());
				System.out.println("执行对象ID："+task.getExecutionId());
				System.out.println("流程定义ID:"+ task.getProcessDefinitionId());
			});*/
		}
	}

	/**
	 * 完成我的任务
	 */
	@Test
	public void completeMyPersonalTask() {
		String taskId ="15005";
		processEngine.getTaskService() //与正在执行的任务管理相关的service
				.complete(taskId);
		System.out.println("完成任务ID: " + taskId);
		
	}
	
	// 完成我的任务
	@Test
	public void completeMyPersonalTaskaaa() {
		String taskId ="2505";
		processEngine.getTaskService() //与正在执行的任务管理相关的service
				.complete(taskId);
		System.out.println("完成任务ID: " + taskId);
		
	}

}
