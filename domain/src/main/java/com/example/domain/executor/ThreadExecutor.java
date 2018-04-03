package com.example.domain.executor;

import java.util.concurrent.Executor;

/**
 * Created by tinyfight on 2018/3/26.
 */

/**
 * Executor 实现类可以根据不同的异步执行框架进行异步执行，但是每个实现类都需要在子线程执行interactor的execute方法
 */
public interface ThreadExecutor extends Executor {

}
