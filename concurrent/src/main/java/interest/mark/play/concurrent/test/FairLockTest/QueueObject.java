package interest.mark.play.concurrent.test.FairLockTest;

/**
 * @author mark on 16/6/17.
 */
public class QueueObject {
    public synchronized void doWait() throws InterruptedException {
        this.wait();
    }
    public synchronized void doNotify(){
        this.notify();
    }
}
