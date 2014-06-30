package thread;

class WaitThreadStop extends Thread {
	
	WaitThreadStop() {
	}
	
	WaitThreadStop(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println("call run()");
		for(int count=1,row=1;row<10;count++,row++) {
			for(int i=0;i<count;i++) {
				System.out.print("*");
			}
			System.out.print("\t wait...");
			System.out.println();
		}
	}
}

public class WaitThreadStopMain {
	
	public static void main(String[] args) {
		WaitThreadStopMain test = new WaitThreadStopMain();
		//test.Method1();
		test.Method2();
	}
	
	public void Method1() {
		System.out.println("call Method1()");
		WaitThreadStop th1 = new WaitThreadStop();
		WaitThreadStop th2 = new WaitThreadStop();
		th1.start();
		while(th1.isAlive()) {
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		th2.start();
	}
	
	public void Method2() {
		System.out.println("call Method2()");
		WaitThreadStop th1 = new WaitThreadStop();
		WaitThreadStop th2 = new WaitThreadStop();
		th1.start();
		try {
			th1.join();
		} catch(Exception e) {
			e.printStackTrace();
		}
		th2.start();
	}
}