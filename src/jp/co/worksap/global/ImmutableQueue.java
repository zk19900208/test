package jp.co.worksap.global;

import java.util.Collection;
import java.util.LinkedList;
import java.lang.IllegalArgumentException;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of objects.
 * @param <E>
*/
class ImmutableQueue<E> extends LinkedList<E> {
	
	/**
	 * requires default constructor.
	*/
	
	public ImmutableQueue(){
		// modify this constructor if necessary, but do not remove default constructor
		super();
	}
	
	// add other constructors if necessary
	public ImmutableQueue(Collection<? extends E> c){
		super(c);
	}
	
	/**
     * Returns the queue that adds an item into the tail of this queue without modifying this queue.
     * <pre>
     * e.g.
     * When this queue represents the queue (2,1,2,2,6) and we enqueue the value 4 into this queue,
     * this method returns a new queue (2,1,2,2,6,4)
     * and this object still represents the queue (2,1,2,2,6)
     * </pre>
     * if the element e is null,throws IllegalArgumentException.
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
	
	public ImmutableQueue<E> enqueue(E e){
		if(e==null) {
			throw new IllegalArgumentException();
		}
		ImmutableQueue<E> temp=new ImmutableQueue<E>(this);
		temp.add(e);
		return temp;
	}
	
	/**
     * Returns the queue that removes the object at the head of this queue without modifying this queue.
     * <pre>
     * e.g.
     * When this queue represents the queue (7,1,3,3,5,1) .
     * this method returns a new queue (1,3,3,5,1)
     * and this object still represents the queue (7,1,3,3,5,1)
     * </pre>
     * If this queue is empty, throws java.util.NoSuchElementException.
     * @return
     * @throws java.util.NoSuchElementException
     */
	
	public ImmutableQueue<E> dequeue() {
		if (this.isEmpty()) {
            throw new NoSuchElementException();
		}
		ImmutableQueue<E> temp=new ImmutableQueue<E>(this);
		temp.poll();
		return temp;
	}
	
	/**
     * Looks at the object which is the head of this queue without removing it from the queue.
     * <pre>
     * e.g.
     * When this queue represents the queue (7,1,3,3,5,1) .
     * this method returns 7 and this object still represents the queue (7,1,3,3,5,1)
     * </pre>
     * If this queue is empty, throws java.util.NoSuchElementException.
     * @return
     * @throws java.util.NoSuchElementException
     */
	
	public E peek(){
		if (this.isEmpty()) {
            throw new NoSuchElementException();
		}
		return this.getFirst();
	}
	
	/**
     * Returns the number of objects in this queue.
     * @return
     */
	
	public int size() {
		return super.size();
	}
	
	// main() for testing
	public static void main(String[] args) {
		
		LinkedList<Integer> q=new LinkedList<Integer>();
		int[] a={1,2,3,4,5};
		for(int i=0;i<a.length;i++) {
			q.add(a[i]);
		}
		
		ImmutableQueue<Integer> iq=new ImmutableQueue<Integer>(q);
		System.out.println("original queue:"+iq);
		
		ImmutableQueue<Integer> en=iq.enqueue(6);
		System.out.println("enqueue:"+en);
		
		ImmutableQueue<Integer> de=iq.dequeue();
		System.out.println("dequeue:"+de);
		
		Object pe=iq.peek();
		System.out.println("peek:"+pe);
		
		int l=iq.size();
		System.out.println("length of iq:"+l);
		
		System.out.println("now the queue is:"+iq);
		
		iq.poll();
		System.out.println("After out(),the queue is:"+iq);
	}
}