package interest.mark.play.concurrent.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by mark on 16/6/7.
 */
public class ThreadPoolService {
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS
            ,new ArrayBlockingQueue<Runnable>(5));

    public static void runTask(Runnable task){
        executor.execute(task);

        System.out.println("线程数"+executor.getPoolSize()+",等待数"+executor.getQueue().size()
                +",已完成"+executor.getCompletedTaskCount());
    }

    public static void shutdown(){
        executor.shutdown();
    }
}
