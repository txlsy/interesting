package interest.mark.play.concurrent.test.FairLockTest;

/**
 * @author mark on 16/6/17.
 */
public class QueueObject {
    private boolean wasNotified = false;

    public synchronized void doWait() throws InterruptedException {
        if (!this.wasNotified) this.wait();
    }

    public synchronized void doNotify(){
        this.wasNotified = true;
        this.notify();
    }
}
