package jp.co.worksap.global;

import java.util.LinkedList;
import java.util.Queue;

import jp.co.worksap.global.PersistentQueue;

public class Test {
	Queue<Integer> q=new LinkedList<Integer>();
	public Test() {
		q.add(1);
		q.add(2);
	}
	
	public Test(LinkedList<Integer> ll) {
		q.addAll(ll);
	}
	
	public void print() {
		System.out.println(q);
	}
	public void add() {
		q.add(3);
	}
	public void get() {
		int i=q.poll();
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> ll =new LinkedList<Integer>();
		int[] a={1,2,3,4,5};
		for(int i=0;i<a.length;i++) {
			ll.add(a[i]);
		}
		Test t=new Test(ll);
		t.print();
		t.add();
		t.print();
		//t.get();
		int j=ll.poll();		
		System.out.println(ll);
		t.print();
	}
}