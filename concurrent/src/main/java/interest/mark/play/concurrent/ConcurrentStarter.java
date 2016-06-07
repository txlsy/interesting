package interest.mark.play.concurrent;

import interest.mark.play.concurrent.service.ThreadPoolService;
import interest.mark.play.concurrent.test.ThreadPoolTest;
import interest.mark.play.concurrent.test.ThreadPoolTest2;

/**
 * Created by mark on 16/5/28.
 */
public class ConcurrentStarter {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 7; i++) {
            ThreadPoolTest test = new ThreadPoolTest(i);
            ThreadPoolService.runTask(test);
//            Thread.sleep(500);
        }
        for (int i = 0; i < 7; i++) {
            ThreadPoolTest2 test = new ThreadPoolTest2(i);
            ThreadPoolService.runTask(test);
//            Thread.sleep(500);
        }
    }
}
