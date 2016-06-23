package interest.mark.play.concurrent.test.FairLockTest;

/**
 * @author mark on 16/6/17.
 */
public class FairLockStarter2 implements Runnable {
    private FairSynchronizer synchronizer;

    public FairLockStarter2(FairSynchronizer synchronizer){
        this.synchronizer = synchronizer;
    }

    public void run() {
        synchronizer.doSomething();
    }

    public static void main(String... args){
        FairSynchronizer synchronizer = new FairSynchronizer();
        Thread t1 = new Thread(new FairLockStarter2(synchronizer));
        Thread t2 = new Thread(new FairLockStarter2(synchronizer));
        Thread t3 = new Thread(new FairLockStarter2(synchronizer));
        t1.start();
        t2.start();
        t3.start();
    }
}
