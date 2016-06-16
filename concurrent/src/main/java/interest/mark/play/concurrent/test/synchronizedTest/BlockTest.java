package interest.mark.play.concurrent.test.synchronizedTest;

import java.util.Date;

/**
 * Created by mark on 16/6/16.
 *
 * 一次只有一个线程能够在同步于同一个监视器对象的Java方法内执行
 */
public class BlockTest {
    private final MyMonitor myMonitor = new MyMonitor();

    public void doSleep20(){
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "," + new Date().getTime());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "," + new Date().getTime());
        }
    }

    public void doSleep2000(){
        synchronized (myMonitor) {
            System.out.println(Thread.currentThread().getName() + "," + new Date().getTime());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "," + new Date().getTime());
        }
    }

    class MyMonitor {

    }

    public static void main(String... args){
        final BlockTest blockTest = new BlockTest();
        Thread t1 = new Thread("t1"){
            public void run(){
                blockTest.doSleep2000();
            }
        };
        Thread t2 = new Thread("t2"){
            public void run(){
                blockTest.doSleep20();
            }
        };
        t1.start();
        t2.start();
    }
}
