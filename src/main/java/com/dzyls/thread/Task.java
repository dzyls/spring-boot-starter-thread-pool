package com.dzyls.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author <a href="stringnotnull@gmail.com">dzyls</a>
 * @Date 2021/8/20 22:25
 * @Version 1.0.0
 * @Description:
 */
public abstract class Task implements Runnable{


    private volatile boolean stopped = false;

    protected volatile AtomicBoolean started = new AtomicBoolean(false);

    private Thread thread;

    public Task() {

    }

    public void start(){
        if (!started.compareAndSet(false,true)){
            return;
        }
        stopped = false;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public void shutdown(boolean interrupt){
        if (!started.compareAndSet(true,false)){
            return;
        }
        stopped = true;
        if (interrupt){
            this.thread.interrupt();
        }
    }

    public boolean isStopped() {
        return stopped;
    }

}
