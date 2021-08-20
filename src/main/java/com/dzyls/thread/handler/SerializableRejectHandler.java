package com.dzyls.thread.handler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author <<a href="stringnotnull@gmail.com">dzyls</a>
 * @Date 2021/8/20 21:52
 * @Version 1.0.0
 * @Description:
 */
public abstract class SerializableRejectHandler implements RejectedExecutionHandler {

    private String executorName;

    public SerializableRejectHandler(String executorName) {
        this.executorName = executorName;
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        putNewTask(r,executorName);
    }

    public abstract Runnable fetchRunnableTask();

    protected abstract boolean putNewTask(Runnable r,String executorName);
}
