package interest.mark.play.concurrent.test.FairLockTest;

/**
 * @author mark on 16/6/17.
 */
public class FairSynchronizer {
    private FairLock lock = new FairLock();

    public void doSomething(){
        try {
            lock.lock();
            Thread.sleep(2000);
            //do something which takes a long time
            System.out.println(Thread.currentThread().getName() + " do something");
            lock.unLock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
