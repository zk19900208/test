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
                Timer t = new Timer() ;    // ����Timer�����
                MyTask mytask = new MyTask() ;    // ��������
                t.schedule(mytask,0,5000) ;    // ���������ִ�У�0���ʼ��ÿ5���ظ�����һ��           
    }
}
class Test4 extends Thread{
    @Override
    public void run() {
        System.out.println("11111111111111");
    }
}

class MyTask extends TimerTask {    // ��������඼Ҫ�̳�TimerTask
    Test4 t = new Test4(); 
    public void run(){
        t.run();
    }
}