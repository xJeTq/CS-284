import java.util.Iterator;
import java.util.NoSuchElementException;

/*
	Name: Anthony Curcio-Petraccoro
	Pledge: I pledge my honor that I have abided by the Stevens Honor System. 
*/

public class ListQueue<E> {

	//@SuppressWarnings("hiding")
	public static class Node<E> {
		
		private E data;
		private Node<E> next;
		private int priority;
		
		/*
		 * Node constructor builds a node with data only. 
		 */
		
		public Node(E dataItem) {
			
			this.data = dataItem;
			this.next = null;
			this.priority = Integer.MAX_VALUE; 
			
		}
		
		/*
		 *  Node constructor builds a node with data and priority. 
		 */
		
		public Node(E dataItem, int priority) {
			
			this.data = dataItem;
			this.next = null;
			this.priority = priority;
			
		}
		
		/*
		 * Node constructor builds a node with data, priority and the next node. 
		 */
		
		public Node(E dataItem, Node<E> next, int priority) {
			
			this.data = dataItem;
			this.next = next;
			this.priority = priority;
			
		}
		
		/*
		 * getData retrieves the data. 
		 */
		
		public E getData() {
			
			return this.data;
			
		}
		
		/*
		 * getNext retrieves the next node. 
		 */
		
		public Node<E> getNext() {
			
			return this.next;
			
		}
		
	}
	
	public class Iter implements Iterator<E> {
		
		private Node<E> next = front;
		
		/*
		 * hasNext returns true if there is a next node, and false if there isn't. 
		 */
		
		public boolean hasNext() {
			
			if (this.next == null) {
				
				return false;
				
			} else {
				
				return true;
				
			}
			
		}
		
		/*
		 * next returns the data of the next node and sets the next node to the next next node. 
		 */
		
		public E next() {
						
			if (next == null) {
				
				throw new NoSuchElementException();
				
			}
			
			E temp = next.data;
			this.next = next.next;
			
			return temp;
			
		}
		
		/*
		 * remove throws an UnsupportedOperationException. 
		 */
		
		public void remove() {
			
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	private Node<E> front;
	private int size;
	
	/*
	 * ListQueue constructor builds an empty singly-linked list. 
	 */
	
	public ListQueue() {
		
		this.front = null;
		this.size = 0;
		
	}
	
	/*
	 * ListQueue contructs a singly-linked list with a first node. 
	 */
	
	public ListQueue(Node<E> first) {
		
		this.front = first;
		this.size ++;
		
	}
	
	/*
	 * getFront returns the node at the first location of the singly-linked list. 
	 */
	
	public Node<E> getFront() {
		
		if (this.front == null) {
			
			throw new NoSuchElementException("Active list is empty.");
			
		}
		
		return this.front;
		
	}
	
	/*
	 * setFront sets the first location of the singly-linked list with the given node. 
	 */
	
	public void setFront(Node<E> front) {
		
		this.front = front;
		
	}
	
	/*
	 * getSize returns the size of the singly-linked list. 
	 */
	
	public int getSize() {
		
		return this.size;
		
	}
	
	/*
	 * peek returns the data of the node in the first location of the singly-linked list. 
	 */
	
	public E peek() {
		
		if (this.front == null) {
			
			throw new NoSuchElementException();
			
		}
		
		return this.front.data;
		
	}
	
	/*
	 * offer creates a node from a given item and adds it to the singly-linked list based on its given priority. 
	 */
	
	public boolean offer(E item, int priority) { 
		
		// Node<E> itemNode = new Node(item);
		
		if (priority < 0 /*|| priority > size*/) {
			
			throw new IllegalArgumentException();
			
		}
		
		if (item == null) {
			
			throw new NullPointerException("Item is empty.");
			
		}
				
		if (front == null) {
			
			front = new Node<E>(item, priority);
			size ++;
			
		} else {
			
			Node<E> itemNode = new Node<E>(item, priority); 
			Node<E> curr = front;
			
			while (curr.next != null && curr.next.priority <= priority) {
				
				curr = curr.next;
				
			}
			
			if (front.priority > priority) {
				
				Node<E> tempNode = front;
				itemNode.next = tempNode;
				front = itemNode;
				size ++;
				
				return true;
				
			} else {
				
				itemNode.next = curr.next;
				curr.next = itemNode;
				size ++;
				
				return true;
				
			}
			
		}
				
		return true;
		
		/*if (front == null) {
			
			front = itemNode;
			
		}
		
		for (int i = 0; i < priority; i ++) {
			
			front = front.next;
			
		}
		
		Node<E> temp = front.next;
		front.next = itemNode;
		itemNode.next = temp;
		size ++;
		return true;*/
		
	}
	
	/*
	 * addRear creates a node from given data and adds it the end of the singly-linked list. 
	 */
	
	public boolean addRear(E item) { 
		
		Node<E> itemNode = new Node<E>(item);
		Node<E> curr = front;
		
		if (item == null) {
			
			throw new NoSuchElementException();
			
		}
		
		if (curr == null) {
		
			front = new Node<E>(item);
			size ++;
			return true;
			
		}
		
		while (curr.next != null) {
			
			curr = curr.next;
			
		}
		
		itemNode.next = curr.next;
		curr.next = itemNode;
		size ++;
		
		return true;
		
	}
	
	/*
	 * poll returns the data from the node at the front of the singly-linked list and removes it from the list. 
	 */
	
	public E poll() {  
		
		if (this.front == null) {
			
			throw new NoSuchElementException();
			
		}
		
		E item = front.data;
		front = front.next;
		size --;
		
		return item;
		
	}
	
	/*
	 * removes a given node from the singly-linked list. 
	 */
	
	public boolean remove(Node<E> toBeRemoved) { // Check. 
		
		Node<E> curr = front;
		int originalSize = size;
		
		if (toBeRemoved == null) {
			
			return true;
			
		}
		
		if (front == toBeRemoved) {
			
			front = front.next;
			size --;
			
			return true;
			
		}
		
		for (int i = 0; i < size - 1; i ++) {
			
			if (curr.next == toBeRemoved) {
				
				curr.next = curr.next.next;
				size --;
				
				return true;
								
			} else {
				
				curr = curr.next;
				
			}
			
		}
		
		return false;
		
	}
	
	/*
	 * iterator returns the instance of the iter class that was defined within the ListQueue class. 
	 */
	
	public Iterator<E> iterator() { 
		
		return new Iter();
		
	}
	
}
