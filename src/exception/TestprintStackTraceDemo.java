package exception;

public class TestprintStackTraceDemo {
	public static void main(String args[]) {
		try {    // ��method1 ���������쳣����
			method1();    // ����method1 ���� 
		}
		catch(Exception e) {
			e.printStackTrace();     // ��ȡ�쳣��Ϣ 
		}
	}
	static void method1() {
		method2();    // ����method2 ���� 
    }
	static void method2() {
		method3();    // ����method3 ����
	}
	static void method3() {
		String str=null;    // �ַ�����ֵΪ null
		int n=str.length();      // ��ȡ�ַ����ĳ��� 
	}
} 