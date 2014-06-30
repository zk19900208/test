package apiDemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

class smallTest {
	public static void main(String[] args) {
		
		/* timeZone≤‚ ‘
		String[] timeZone=TimeZone.getAvailableIDs();
		for( int i=0;i<timeZone.length;i++) {
			System.out.println(timeZone[i]);
		}
		*/
		
		/* set≤‚ ‘
		String s="hu";
		Set<String> set=new HashSet<String>(Arrays.asList(new String[]{"hu","zunli","li"}));
		for(String ss:set) {
			System.out.println(ss);
		}
		if(set.contains(s)) {
			System.out.println("s is in set");
		} else {
			System.out.println("s is out set");
		}
		*/
		
		/* string∏≥÷µ≤‚ ‘
		String s1="s1";
		String s2=s1;
		s1="s3";
		System.out.println(s2);
		System.out.println(s1);
		if(s2==s1) {
			System.out.println("the address of s2 and s1 is equal");
		} else {
			System.out.println("the address of s2 and s1 is not equal");
		}
		*/
		
		// ∂˛Œ¨ ˝◊È≤‚ ‘
		String[][] s=new String[2][];
		s[0][0]="a";
		s[0][1]="b";
		System.out.println(s);
		
	}
}