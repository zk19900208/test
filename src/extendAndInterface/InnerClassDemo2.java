package extendAndInterface;

class Outer2 {
	String out_string = "String in Outer";
	void useIner1() {
		Iner1 in1 = new Iner1();
		in1.print(); 
	}
	void useIner2() {
		Iner2 in2 = new Iner2();
		in2.print();
	}
	
	//�Ǿ�̬�ڲ��� 
	class Iner1 {
		void print() {
			System.out.println("Iner1.print()");
			//����ֱ��ʹ��������ı���
			System.out.println("Outer.out_string=" + out_string + "");
		}
	}
	//��̬�ڲ���
	static class Iner2
	{
		void print() {
			System.out.println("Iner2.print()");
			//System.out.println("Outer.out_string=" + out_string + "");
			//��Ҫʹ�ö���������������ı���
			Outer3 outer = new Outer3();
			System.out.println("Outer.out_string=" + outer.out_string);
		}
	}
} 

public class InnerClassDemo2 {
	public static void main(String[] args) {
		Outer2 out = new Outer2();
		out.useIner1();
		out.useIner2();
	}
}