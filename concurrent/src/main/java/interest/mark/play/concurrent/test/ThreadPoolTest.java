package interest.mark.play.concurrent.test;

import interest.mark.play.concurrent.service.ThreadPoolService;

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

        for (int i = 0; i < 15; i++) {
            ThreadPoolTest test = new ThreadPoolTest(i);
            ThreadPoolService.runTask(test);
//            Thread.sleep(500);
        }

    }
}
