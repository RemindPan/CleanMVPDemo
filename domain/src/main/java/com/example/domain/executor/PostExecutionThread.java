package com.example.domain.executor;

/**
 * Created by tinyfight on 2018/3/24.
 */

import io.reactivex.Scheduler;

/**
 * 抽象出来，从任何线程更改到任何其他线程来执行上下文操作。
 * 例如对主线程封装以后，在后台执行任务时，该接口的实现类可以切换上下文环境，并执行ui更新
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
