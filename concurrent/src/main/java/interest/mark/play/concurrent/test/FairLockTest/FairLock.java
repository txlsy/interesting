package interest.mark.play.concurrent.test.FairLockTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mark on 16/6/17.
 */
public class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException {
        QueueObject object = new QueueObject();
        System.out.println(Thread.currentThread().getName()+" 1");

        synchronized (this) {
            waitingThreads.add(object);
            System.out.println(waitingThreads.size());
        }
        while (true) {
            synchronized (this) {
                if (!isLocked){
                    isLocked = true;
                    lockingThread = Thread.currentThread();
                    waitingThreads.remove(object);
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + " 2");
            object.doWait();
            System.out.println(Thread.currentThread().getName() + " 3");
        }
        System.out.println(Thread.currentThread().getName()+" 4");


//        while (isLocked) {
//            waitingThreads.add(object);
//            System.out.println(Thread.currentThread().getName() + " 2");
//            object.doWait();
//            System.out.println(Thread.currentThread().getName() + " 3");
//            waitingThreads.remove(object);
//        }
//        isLocked = true;
//        lockingThread = Thread.currentThread();
//        System.out.println(Thread.currentThread().getName()+" 4");


//        QueueObject queueObject           = new QueueObject();
//        boolean     isLockedForThisThread = true;
//        synchronized(this){
//            waitingThreads.add(queueObject);
//        }
//
//        while(isLockedForThisThread){
//            synchronized(this){
//                isLockedForThisThread =
//                        isLocked || waitingThreads.get(0) != queueObject;
//                if(!isLockedForThisThread){
//                    isLocked = true;
//                    waitingThreads.remove(queueObject);
//                    lockingThread = Thread.currentThread();
//                    return;
//                }
//            }
//            try{
//                queueObject.doWait();
//            }catch(InterruptedException e){
//                synchronized(this) { waitingThreads.remove(queueObject); }
//                throw e;
//            }
//        }
    }

    public synchronized void unLock() {
        if (lockingThread!=Thread.currentThread()){
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        if (waitingThreads.size()>0) {
            System.out.println(Thread.currentThread().getName() + " 5");
            waitingThreads.get(0).doNotify();
            System.out.println(Thread.currentThread().getName() + " 6");
        }
    }
}
