package extendAndInterface;

class A {
	A() {
		System.out.println("调用A的无参构造函数");
	}
	A(int i) {
		System.out.println("调用A的有参构造函数");
	}
}

class B extends A {
	B() {
		System.out.println("调用B的无参构造函数");
	}
	B(int i) {
		super(i);
		System.out.println("调用B的有参构造函数");
	}
}

class C extends B {
	C() {
		System.out.println("调用C的无参构造函数");
	}
	C(int i) {
		super(i);
		System.out.println("调用C的有参构造函数");
	}
}

public class extend {
	public static void main(String[] args) {
		C c = new C();
		C ci = new C(5);
	}
}