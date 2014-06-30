package thread;

public class threadStart {
	public static void main(String[] args) {
		Runnable rb = new RunnableThread();
		Thread td = new Thread(rb);
		td.start();
		SubThread1 st = new SubThread1();
		st.start();
	}
}

class RunnableThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("RunnableThread∆Ù∂Ø");
	}
	
}

class SubThread1 extends Thread {
	
	SubThread1() {
	}
	
	SubThread1(String name) {
		super(name);
	}
	public void run() {
		System.out.println("SubThread∆Ù∂Ø");
	}
}