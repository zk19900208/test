package extendAndInterface;

class A {
	A() {
		System.out.println("����A���޲ι��캯��");
	}
	A(int i) {
		System.out.println("����A���вι��캯��");
	}
}

class B extends A {
	B() {
		System.out.println("����B���޲ι��캯��");
	}
	B(int i) {
		super(i);
		System.out.println("����B���вι��캯��");
	}
}

class C extends B {
	C() {
		System.out.println("����C���޲ι��캯��");
	}
	C(int i) {
		super(i);
		System.out.println("����C���вι��캯��");
	}
}

public class extend {
	public static void main(String[] args) {
		C c = new C();
		C ci = new C(5);
	}
}