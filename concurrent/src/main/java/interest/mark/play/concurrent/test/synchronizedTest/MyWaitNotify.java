package interest.mark.play.concurrent.test.synchronizedTest;

/**
 * Created by mark on 16/6/15.
 *
 *
 */
public class MyWaitNotify {

    private final MyMonitor myMonitor = new MyMonitor();
    private boolean was = false;

    public void doWait(){
        synchronized (myMonitor){
            if (!was) {
                try {
                    System.out.println(Thread.currentThread().getName() + "wait1");
                    myMonitor.wait();
                    System.out.println(Thread.currentThread().getName() + "wait2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"do something");
            was = false;
        }
    }

    public void doNotify(){
        synchronized (myMonitor){
            was = true;
            System.out.println(Thread.currentThread().getName()+"notify1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myMonitor.notify();
            System.out.println(Thread.currentThread().getName()+"notify2");
        }
    }

    class MyMonitor {

    }

    public static void main(String... args){
        final MyWaitNotify myWaitNotify = new MyWaitNotify();
        Thread t1 = new Thread("t1"){
            public void run(){
                myWaitNotify.doWait();
            }
        };
        Thread t2 = new Thread("t2"){
            public void run(){
                myWaitNotify.doWait();
            }
        };
        Thread t3 = new Thread("t3"){
            public void run(){
                myWaitNotify.doNotify();
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}
