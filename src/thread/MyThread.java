package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread extends Thread{
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		String name=Thread.currentThread().getName();
		System.out.println(name+" is running");		
		if(name=="pool-1-thread-9") {
			System.out.println("equal");
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" is finished");
	}
	
	public static void main(String[] args) {
		System.out.println();
		ExecutorService pool=Executors.newCachedThreadPool();
		
		int n=10;
		MyThread[] threads=new MyThread[n];
		for(int i=0;i<n;i++) {
			threads[i]=new MyThread();
		}
		for(int i=0;i<10;i++) {
			pool.execute(threads[i]);
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}
}