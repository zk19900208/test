package exception;

public class TestprintStackTraceDemo {
	public static void main(String args[]) {
		try {    // 对method1 方法进行异常处理
			method1();    // 调用method1 方法 
		}
		catch(Exception e) {
			e.printStackTrace();     // 获取异常信息 
		}
	}
	static void method1() {
		method2();    // 调用method2 方法 
    }
	static void method2() {
		method3();    // 调用method3 方法
	}
	static void method3() {
		String str=null;    // 字符串的值为 null
		int n=str.length();      // 获取字符串的长度 
	}
} 