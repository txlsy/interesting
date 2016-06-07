package interest.mark.play.concurrent.test;

/**
 * Created by mark on 16/6/7.
 */
public class ThreadPoolTest2 implements Runnable {
    private int taskNum;

    public ThreadPoolTest2(int taskNum){
        this.taskNum = taskNum;
    }

    public void run() {
        System.out.println("正在执行任务"+taskNum);

        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("任务"+taskNum+"执行完毕");
    }
}
