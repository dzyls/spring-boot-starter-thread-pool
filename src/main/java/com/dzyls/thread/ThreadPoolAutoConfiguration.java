package com.dzyls.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author <a href="stringnotnull@gmail.com">dzyls</a>
 * @Date 2021/8/20 21:49
 * @Version 1.0.0
 * @Description:
 */
@Configuration
public class ThreadPoolAutoConfiguration {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(){
        return new ThreadPoolExecutor(5,10,1, TimeUnit.SECONDS,new ArrayBlockingQueue<>(50));
    }

}
