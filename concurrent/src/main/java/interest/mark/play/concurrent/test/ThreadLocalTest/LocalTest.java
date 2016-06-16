package interest.mark.play.concurrent.test.ThreadLocalTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mark on 16/6/16.
 */
public class LocalTest {
    private ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        protected String initialValue(){
            return "initial";
        }
    };

    public void setValue(String v){
        threadLocal.set(v);
    }

    public String getValue(){
        return threadLocal.get();
    }

    public static void main(String... args){
        final LocalTest test = new LocalTest(){
            public void noName(){
                System.out.println("noName");
            }
        };
        new Thread("t1"){
            public void run(){
                test.setValue("ss");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+","+test.getValue());
                try {
                    Method method = test.getClass().getMethod("noName");
                    method.invoke(test);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread("t2"){
            public void run(){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.setValue("rr");
                System.out.println(Thread.currentThread().getName()+","+test.getValue());
            }
        }.start();
    }
}
