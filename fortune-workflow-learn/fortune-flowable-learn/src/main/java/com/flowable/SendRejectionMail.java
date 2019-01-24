package com.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @author pinker.lin
 * @version V1.0
 * @date Created In 15:20 2019/1/24
 */
public class SendRejectionMail implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("send Rejection external system for employee "
                + execution.getVariable("employee"));
    }

}

