package call;

class sub {
	isubclass isubc;
	public sub(isubclass i) {
		isubc = i;
	}
	
	public int sout() {
		System.out.println("call sout in sub.class");
		main.mout();
		int i=10;
		return i;
	}
	
	interface isub {
		public void isubprint();
	}
	
	public static class isubclass implements isub {
		@Override
		public void isubprint() {	
		}
	}
	
	public void print() {
		isubc.isubprint();
	}
	
	public void sprint() {
		print();
	}
}