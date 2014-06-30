package apiDemo;

public class Controller {
	static Controller c=new Controller();
	private int i=0;
	public int getInt() {
		i+=1;
		System.out.println("i="+i);
		return i;
	}
}