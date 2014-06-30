package thread;

class share {
	public static int j;
}

class ThreadDemo2 extends Thread {
	private share s;
	ThreadDemo2() {
	}
	
	ThreadDemo2(share s) {
		this.s=s;
	}
	
	public void add() {
		synchronized(s) {
			s.j++;
			String threadName=Thread.currentThread().getName();
			System.out.println(threadName+" in add() ;j="+s.j);
		}
		
	}
	// 重载run函数
	public void run() {
		add();
		String threadName=Thread.currentThread().getName();
		System.out.println(threadName+";j="+s.j);
		/*
		for (int count = 1,row = 1; row < 10; row++,count++) {    // 循环计算输出的*数目
			for (int i = 0; i < count; i++) {    //循环输出指定的 count 数目的*
				System.out.print('*');    //输出*
			}
			System.out.println();    //输出换行
		}
		*/
	}
	
	public static void main(String[] args) {
		share s=new share();
		ThreadDemo2 td1 = new ThreadDemo2(s);
		ThreadDemo2 td2 = new ThreadDemo2(s);
		ThreadDemo2 td3 = new ThreadDemo2(s);
		td1.start();
		td2.start();
		td3.start();
	}
}