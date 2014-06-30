package call;

import call.sub.isubclass;

class main implements i{
	static int i=0;
	public main() {
		subm sm = new subm();
		sub s = new sub(sm);
		i = s.sout();
		s.sprint();
	}
	
	@Override
	public void isub() {
		System.out.println("call isub() in main class; now i="+i);
	}
	
	public static void mout() {
		System.out.println("call mout() in main class; now i="+i);
	}
	
	public static void main(String[] args) {
		main m =new main();
	}
	
	class subm extends isubclass {
		public void isubprint() {
			System.out.println("main.subm.isubprint(); now i="+i);
		}
	}
}