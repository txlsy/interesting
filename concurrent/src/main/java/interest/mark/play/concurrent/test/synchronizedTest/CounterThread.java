package interest.mark.play.concurrent.test.synchronizedTest;

import java.util.Date;

/**
 * Created by mark on 16/6/15.
 */
public class CounterThread extends Thread {
    private Counter counter;

    public CounterThread(Counter counter,String name){
        super(name);
        this.counter = counter;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            long a = (new Date().getTime());
            counter.add(i);
//            System.out.println("time "+Thread.currentThread().getName()+","+((new Date().getTime())-a));
//            counter.show();
        }
        counter.show();
    }

    public static void main(String args[]){
        Counter counter = new Counter();
        CounterThread ct1 = new CounterThread(counter,"1");
        CounterThread ct2 = new CounterThread(counter,"2");
        ct1.start();
        ct2.start();
    }
}
