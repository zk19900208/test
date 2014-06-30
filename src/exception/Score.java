package exception;

class IllegalScoreException extends Exception{
	IllegalScoreException() {
	}
	IllegalScoreException(String msg) {
		// ���ø���Ĺ��췽�� 
		super(msg);
	} 
} 
public class Score{
	public static void main(String args[]) {
		try {
			String level=null;
			level=scoreLevel(90);
			System.out.println("90 �ֵĳɼ��ȼ�Ϊ��"+level);
			level=scoreLevel(120);
			System.out.println("120 �ֵĳɼ��ȼ�Ϊ��"+level);
    	}
		catch(IllegalScoreException e) {
			System.out.println("catch Exception");
			e.printStackTrace();
		}
	}
    static String scoreLevel(int score) throws IllegalScoreException {
    	if(score>=85&&score<=100)
    		return "A";
    	else if(score>=75&&score<85)
    		return "B";
    	else if(score>=60&&score<75)
    		return "C";
    	else if(score<60&&score>=0)
    		return "D";
    	else
    		throw new IllegalScoreException("�Ƿ��ķ���");  
   }
} 