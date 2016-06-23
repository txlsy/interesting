package interest.mark.play.concurrent.test.FairLockTest;

/**
 * @author mark on 16/6/17.
 */
public class FairLockStarter implements Runnable {

    private Synchronizer synchronizer;

    public FairLockStarter(Synchronizer synchronizer){
        this.synchronizer = synchronizer;
    }

    public void run() {
        synchronizer.doSomething();
    }

    public static void main(String... args){
        Synchronizer synchronizer = new Synchronizer();
        Thread t1 = new Thread(new FairLockStarter(synchronizer));
        Thread t2 = new Thread(new FairLockStarter(synchronizer));
        Thread t3 = new Thread(new FairLockStarter(synchronizer));
        t1.start();
        t2.start();
        t3.start();
    }
}
