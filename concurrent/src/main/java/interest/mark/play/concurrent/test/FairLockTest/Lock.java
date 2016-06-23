package interest.mark.play.concurrent.test.FairLockTest;

/**
 * @author mark on 16/6/17.
 */
public class Lock {
    private boolean isLock = false;
    private Thread lockingThread = null;

    public synchronized void lock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" 1");
        while (isLock){
            System.out.println(Thread.currentThread().getName()+" 2");
            wait();
            System.out.println(Thread.currentThread().getName()+" 5");
        }
        isLock = true;
        lockingThread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+" 6");
    }

    public synchronized void unLock() {
        if (lockingThread!=Thread.currentThread()){
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLock = false;
        System.out.println(Thread.currentThread().getName()+" 3");
        notify();
        System.out.println(Thread.currentThread().getName()+" 4");
    }
}
