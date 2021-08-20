package com.dzyls.thread.handler;

/**
 * @Author <a href="stringnotnull@gmail.com">dzyls</a>
 * @Date 2021/8/20 22:15
 * @Version 1.0.0
 * @Description:
 */
public class DBRejectHandler extends SerializableRejectHandler{

    public DBRejectHandler(String executorName) {
        super(executorName);
    }

    @Override
    public Runnable fetchRunnableTask() {
        // fetch task from db
        return null;
    }

    @Override
    protected boolean putNewTask(Runnable r, String executorName) {
        // insert task to db
        return false;
    }

}
