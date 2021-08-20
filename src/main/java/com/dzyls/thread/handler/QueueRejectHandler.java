package com.dzyls.thread.handler;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author <a href="stringnotnull@gmail.com">dzyls</a>
 * @Date 2021/8/20 22:04
 * @Version 1.0.0
 * @Description:
 */
public class QueueRejectHandler extends SerializableRejectHandler{

    private LinkedBlockingQueue<Runnable> queue;

    public QueueRejectHandler(String executorName) {
        super(executorName);
        queue = new LinkedBlockingQueue<>();
    }

    @Override
    public Runnable fetchRunnableTask() {
        try {
            return queue.poll(-1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override
    protected boolean putNewTask(Runnable r, String executorName) {
        return queue.offer(r);
    }
}
