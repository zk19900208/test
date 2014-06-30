package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class output {
	public static void main(String[] args) {
		HashMap m = new HashMap();
		m.put("0", "0v");
		m.put("1", "1v");
		m.put("2", "2v");
		
		System.out.println("1====");
		for(Object key:m.keySet()) {
			String v = (String)m.get(key);
			System.out.println("key="+key+";value="+v);
		}
		
		System.out.println("2====");
		Iterator it1 = m.keySet().iterator();
		while(it1.hasNext()) {
			String key = (String)it1.next();
			String v = (String)m.get(key);
			System.out.println("key="+key+";value="+v);
		}
		
		System.out.println("3====");
		for(Object s:m.values()) {
			System.out.println(s);
		}
		
		System.out.println("4====");
		Iterator it2 = m.entrySet().iterator();
		while(it2.hasNext()) {
			Entry entry = (Entry)it2.next();
			Object key = entry.getKey();
			Object v = entry.getValue();
			System.out.println("key="+key+";value="+v);
		}
	}
}