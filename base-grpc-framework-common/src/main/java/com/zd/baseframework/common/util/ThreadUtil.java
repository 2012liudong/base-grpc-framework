package com.zd.baseframework.common.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yaoxs@shukun.net
 * @date 2019-04-24 12:02
 */
public class ThreadUtil {

    private static final int MAX_QUEUE_CAPACITY_TEN_THOUSAND = 1000000;

    private static ThreadPoolExecutor EXECUTE_POOL = null;

    private static ThreadPoolExecutor EXECUTE_POOL_ITERATION = null;

    /**
     * 初始化构建下载线程池
     */
    private static void initDownloadThreadPool() {
        if(EXECUTE_POOL == null) {
            synchronized (ThreadUtil.class) {
                if(EXECUTE_POOL == null) {
                    ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("execute-pool-%d").build();
                    EXECUTE_POOL = new ThreadPoolExecutor(16, 64, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(MAX_QUEUE_CAPACITY_TEN_THOUSAND), threadFactory);
                }
            }
        }
    }

    /**
     * 初始化构建下载线程池
     */
    private static void initIterationThreadPool() {
        if(EXECUTE_POOL_ITERATION == null) {
            synchronized (ThreadUtil.class) {
                if(EXECUTE_POOL_ITERATION == null) {
                    ThreadFactory threadFactory =
                            new ThreadFactoryBuilder().setNameFormat("iteration-pool-%d").build();
                    EXECUTE_POOL_ITERATION = new ThreadPoolExecutor(16, 64, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(MAX_QUEUE_CAPACITY_TEN_THOUSAND), threadFactory);
                }
            }
        }
    }

    /**
     * 提交任务到线程池中
     * @param runnable
     * @throws RejectedExecutionException
     */
    public static void submitTask(Runnable runnable) throws RejectedExecutionException {
        initDownloadThreadPool();
        EXECUTE_POOL.submit(runnable);
    }

    /**
     * 提交任务到iteration线程池中
     * @param runnable
     * @throws RejectedExecutionException
     */
    public static void submitIterationTask(Runnable runnable) throws RejectedExecutionException {
        initIterationThreadPool();
        EXECUTE_POOL_ITERATION.submit(runnable);
    }

    /**
     * 批量提交Callable任务
     *
     * @param callableList
     * @return
     * @throws RejectedExecutionException
     */
    public static <T> List<Future<T>> submitCallableTask(List<Callable<T>> callableList) throws RejectedExecutionException {
        initDownloadThreadPool();
        List<Future<T>> futureList = new ArrayList<>(callableList.size());
        callableList.forEach(temp -> futureList.add(EXECUTE_POOL.submit(temp)));
        return futureList;
    }
}
