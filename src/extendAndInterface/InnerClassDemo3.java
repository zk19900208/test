package extendAndInterface;

class Outer3 {
	String out_string = "String in Outer";
	void print() {
		//System.out.println(Iner1.this.in_string1);
		//�����ڲ������
		Iner1 in1 = new Iner1();
		//ͨ��������ʷǾ�̬�ڲ��������
		System.out.println(in1.in_string1);
		//ֱ�ӷ��ʾ�̬�ڲ��������
		System.out.println(Iner2.in_string2);
	}
	class Iner1 {
		String in_string1="String in Iner1";
		Iner1(){
			System.out.println("Constructor of Iner1");
		}
		class InClass_In_Iner1 {
		}
	}
	static class Iner2 {
		static class staticClass_In_Iner2{
		}
		static String in_string2="static String in Iner2";
		Iner2(){
			System.out.println("Constructor of Iner2");
		}
	}
}

public class InnerClassDemo3 {
	public static void main(String[ ] args) {
		//����Outer��Ķ���
		Outer3 outer=new Outer3();
		outer.print();
		//ʹ������ڲ���
		Outer3.Iner1 in1=new Outer3().new Iner1();
		Outer3.Iner2 in2=new Outer3.Iner2();
		Outer3.Iner1.InClass_In_Iner1 inin2=new Outer3().new Iner1().new  InClass_In_Iner1();
		Outer3.Iner1.InClass_In_Iner1 inin1=in1.new InClass_In_Iner1();
		System.out.println(in1);
		System.out.println(in2);
		System.out.println(inin1);
		System.out.println(inin2);
	}
}