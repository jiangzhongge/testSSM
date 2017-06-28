package com.jiang.seven.service.Impl.util;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.alibaba.druid.stat.TableStat.Name;
import com.jiang.seven.interfaces.AfterCommitExecutor;

@Service("afterCommitExecutor")
public class AfterCommitExecutorImpl extends TransactionSynchronizationAdapter implements AfterCommitExecutor{

	private static final Logger LOGGER = LoggerFactory.getLogger(AfterCommitExecutorImpl.class);
    private static final ThreadLocal<List<Runnable>> RUNNABLES = new ThreadLocal<List<Runnable>>();
    private ExecutorService threadPool = Executors.newFixedThreadPool(5);
 
    @Override
    public void execute(Runnable runnable) {
        LOGGER.info("Submitting new runnable {} to run after commit", runnable);
        if (!TransactionSynchronizationManager.isSynchronizationActive()) {
            LOGGER.info("Transaction synchronization is NOT ACTIVE. Executing right now runnable {}", runnable);
            runnable.run();
            return;
        }
        List<Runnable> threadRunnables = RUNNABLES.get();
        if (threadRunnables == null) {
            threadRunnables = new ArrayList<Runnable>();
            RUNNABLES.set(threadRunnables);
            TransactionSynchronizationManager.registerSynchronization(this);
        }
        threadRunnables.add(runnable);
    }
 
    @Override
    public void afterCommit() {
        List<Runnable> threadRunnables = RUNNABLES.get();
        LOGGER.info("Transaction successfully committed, executing {} runnables", threadRunnables.size());
        for (int i = 0; i < threadRunnables.size(); i++) {
            Runnable runnable = threadRunnables.get(i);
            LOGGER.info("Executing runnable {}", runnable);
            try {
                threadPool.execute(runnable);
            } catch (RuntimeException e) {
                LOGGER.error("Failed to execute runnable " + runnable, e);
            }
        }
    }
 
    @Override
    public void afterCompletion(int status) {
        LOGGER.info("Transaction completed with status {}", status == STATUS_COMMITTED ? "COMMITTED" : "ROLLED_BACK");
        RUNNABLES.remove();
    }
}
/**
 * 关于Spring的Async
 * spring为了方便应用使用线程池进行异步化，默认提供了@Async注解，可以整个app使用该线程池，而且只要一个@Async注解在方法上面即可，省去重复的submit操作。
 * 关于async要注意的几点：
 * 1、async的配置
 * <context:component-scan base-package="com.yami" />
   	<!--配置@Async注解使用的线程池，这里的id随便命名，最后在task:annotation-driven executor= 指定上就可以-->
    <task:executor id="myExecutor" pool-size="5"/>
    <task:annotation-driven executor="myExecutor" />
      这个必须配置在root context里头，而且web context不能扫描controller层外的注解，否则会覆盖掉。
    <context:component-scan base-package="com.yami.web.controller"/>
	<mvc:annotation-driven/>
 * 
 * 2、async的调用问题
 * 	async方法的调用，不能由同类方法内部调用，否则拦截不生效，这是spring默认的拦截问题，必须在其他类里头调用另一个类中带有async的注解方法，才能起到异步效果。
 * 
 * 3、事务问题
 * async方法如果也开始事务的话，要注意事务传播以及事务开销的问题。
 * 而且在async方法里头使用如上的TransactionSynchronizationManager.registerSynchronization不起作用，值得注意。
 * 
 * 
 */
