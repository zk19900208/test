package thread;

class ThreadDemo4 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		generate();
	}
	
	public void generate() {
		synchronized(ThreadDemo4.class) {
		for (int count = 1,row = 1; row < 10; row++,count++) {    // ѭ�����������*��Ŀ
			for (int i = 0; i < count; i++) {    //ѭ�����ָ���� count ��Ŀ��*
				System.out.print('*');    //���*
			}
			System.out.println();    //������з�
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