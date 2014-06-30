package thread;

class ThreadDemo4 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		generate();
	}
	
	public void generate() {
		synchronized(ThreadDemo4.class) {
		for (int count = 1,row = 1; row < 10; row++,count++) {    // 循环计算输出的*数目
			for (int i = 0; i < count; i++) {    //循环输出指定的 count 数目的*
				System.out.print('*');    //输出*
			}
			System.out.println();    //输出换行符
		}
		}
	}
	
	public static void main(String[] args) {
		Runnable ra1 = new ThreadDemo4();
		Thread td1 = new Thread(ra1);
		Thread td2 = new Thread(ra1);
		Thread td3 = new Thread(ra1);
		td1.start();
		td2.start();
		td3.start();
	}
}