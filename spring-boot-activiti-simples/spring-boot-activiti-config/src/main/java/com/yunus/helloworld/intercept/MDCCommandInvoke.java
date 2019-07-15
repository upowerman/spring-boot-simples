package com.yunus.helloworld.intercept;

import org.activiti.engine.impl.agenda.AbstractOperation;
import org.activiti.engine.impl.interceptor.DebugCommandInvoker;
import org.activiti.engine.logging.LogMDC;

public class MDCCommandInvoke extends DebugCommandInvoker {


    @Override
    public void executeOperation(Runnable runnable) {
        boolean enabled = LogMDC.isMDCEnabled();
        LogMDC.setMDCEnabled(true);

        if (runnable instanceof AbstractOperation) {
            AbstractOperation operation = (AbstractOperation) runnable;

            if (operation.getExecution() != null) {
                LogMDC.putMDCExecution(operation.getExecution());
            }

        }
        super.executeOperation(runnable);
        LogMDC.clear();
        if (!enabled) {
            LogMDC.setMDCEnabled(false);
        }
    }
}
