package thread;

public class ThreadSleep {
	public static void main(String[] args) {
		SubThread2 st = new SubThread2("SubThread");
		st.start();
	}
}

class SubThread2 extends Thread {
	
	SubThread2() {
	}
	
	SubThread2(String name) {
		super(name);
	}
	
	public void run() {
		for(int count=1,row=1;count<=10;count++,row++) {
			for(int i=0;i<count;i++) {
				System.out.print("*");
			}
			try {
				Thread.sleep(1000);
				System.out.print("\t wait...");
			} catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}
}