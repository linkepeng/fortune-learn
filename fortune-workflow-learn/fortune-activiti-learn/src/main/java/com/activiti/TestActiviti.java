package com.activiti;

import org.activiti.engine.DynamicBpmnService;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

public class TestActiviti {
	
	
	public void test1() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		TaskService taskService = processEngine.getTaskService();
		ManagementService managementService = processEngine.getManagementService();
		IdentityService identityService = processEngine.getIdentityService();
		HistoryService historyService = processEngine.getHistoryService();
		FormService formService = processEngine.getFormService();
		DynamicBpmnService dynamicBpmnService = processEngine.getDynamicBpmnService();
		
		/*ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
		ProcessEngineConfiguration.createProcessEngineConfigurationFromResource(String resource);
		ProcessEngineConfiguration.createProcessEngineConfigurationFromResource(String resource, String beanName);
		ProcessEngineConfiguration.createProcessEngineConfigurationFromInputStream(InputStream inputStream);
		ProcessEngineConfiguration.createProcessEngineConfigurationFromInputStream(InputStream inputStream, String beanName);*/
	}
	
	public void test2() {
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		//工作流的核心对象 processEnginess对象
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		

		RuntimeService runtimeService = processEngine.getRuntimeService();
		//管理流程的定义
		RepositoryService repositoryService = processEngine.getRepositoryService();
		TaskService taskService = processEngine.getTaskService();
		ManagementService managementService = processEngine.getManagementService();
		IdentityService identityService = processEngine.getIdentityService();
		HistoryService historyService = processEngine.getHistoryService();
		FormService formService = processEngine.getFormService();
		DynamicBpmnService dynamicBpmnService = processEngine.getDynamicBpmnService();
		
	}

}
