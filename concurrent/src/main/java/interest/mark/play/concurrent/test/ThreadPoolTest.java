package interest.mark.play.concurrent.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by mark on 16/6/7.
 */
public class ThreadPoolTest implements Runnable {
    private int taskNum;

    public ThreadPoolTest(int taskNum){
        this.taskNum = taskNum;
    }

    public void run() {
        System.out.println("正在执行线程"+taskNum);

        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程"+taskNum+"执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,8,200, TimeUnit.MILLISECONDS
                ,new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            ThreadPoolTest test = new ThreadPoolTest(i);

            executor.execute(test);

            System.out.println("线程数"+executor.getPoolSize()+",等待数"+executor.getQueue().size()
                    +",已完成"+executor.getCompletedTaskCount());
//            Thread.sleep(500);
        }

        executor.shutdown();
    }
}
