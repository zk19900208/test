package thread;

public class ControlThreadTest {
	MyThreadClass r=new MyThreadClass();
	Thread t1=new Thread(r);
	Thread t2=new Thread(r);
	
	MyThreadClassReader rr=new MyThreadClassReader();
	Thread tr=new Thread(rr);
	
	public static void main(String[] args) {
		int j=0;
		ControlThreadTest ctt=new ControlThreadTest();
		ctt.startThread();
		//ctt.stopThread();
	}
	
	public void startThread() {
		t1.start();
		t2.start();
		//tr.start();
	}
	
	public void stopThread() {
		r.stopRunning();
	}
}

class MyThreadClass implements Runnable {
	private boolean flag=true;
	private int i=0;
	@Override
	public synchronized void run() {
		while (flag) {
			System.out.println("i="+i);
			i++;
			try {
				Thread.sleep((long) Math.random() * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i>=50) {
				break;
			}
		}
	}
	
	public void stopRunning() {
		flag=false;
	}
}

class MyThreadClassReader implements Runnable {
	static int i=100;
	
	@Override
	public void run() {
		while(true) {
			System.out.println("MyThreadClassReader.run();i="+i);
			i--;
		}
	}
}