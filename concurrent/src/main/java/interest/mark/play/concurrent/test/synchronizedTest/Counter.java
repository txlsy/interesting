package interest.mark.play.concurrent.test.synchronizedTest;

/**
 * Created by mark on 16/6/15.
 */
public class Counter {
    private long count = 0;
    public
//    synchronized
    void add(long value){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count = this.count+value;
//        System.out.println("add  "+Thread.currentThread().getName()+","+this.count);
    }
    public void show(){
        System.out.println("show "+Thread.currentThread().getName()+","+this.count);
    }
}
