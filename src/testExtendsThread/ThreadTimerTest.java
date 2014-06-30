package testExtendsThread;

import java.util.TimerTask ;
import java.util.Date ;
import java.text.SimpleDateFormat ;
import java.util.Timer ;
public class ThreadTimerTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub        
                Timer t = new Timer() ;    // 建立Timer类对象
                MyTask mytask = new MyTask() ;    // 定义任务
                t.schedule(mytask,0,5000) ;    // 设置任务的执行，0秒后开始，每5秒重复调用一次           
    }
}
class Test4 extends Thread{
    @Override
    public void run() {
        System.out.println("11111111111111");
    }
}

class MyTask extends TimerTask {    // 任务调度类都要继承TimerTask
    Test4 t = new Test4(); 
    public void run(){
        t.run();
    }
}