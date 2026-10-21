package eda;

import java.util.*;

public class LinkedList {
	
	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void addLast(int v) {
		Node nn = new Node(v);
		if (isEmpty()) {
			this.head = nn;
			this.tail = nn;
		} else {
			this.tail.next = nn;
			nn.prev = this.tail;
			this.tail = nn;
		}
		size++;
	}
	
	public void addFirst(int v) {
		Node nn = new Node(v);
		if (isEmpty()) {
			this.head = nn;
			this.tail = nn;
		} else {
			this.head.prev = nn;
			nn.next = this.head;
			this.head = nn;
		}
		size++;
	}
	
	public void add(int index, int v) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		Node nn = new Node(v);
		
		if (index == 0) {
			this.addFirst(v);
		}
		
		if (index == size-1) {
			this.addLast(v);
		} else {
			Node aux = this.head;
			
			for (int i = 0; i < index -1; i++) {
				aux = aux.next;
			}
			nn.next = aux.next;
			aux.next = nn;
			nn.next.prev = nn;
			nn.prev = aux;
		}
		size++;
	}
	
	public int indexOf(int v) {
		Node aux = this.head;
		int index = 0;
		while(aux!=null) {
			if(aux.v == v)
				return index;
			aux = aux.next;
			index++;
		}
		return -1;
	}
	
	public int lastIndexOf(int v) {
		Node aux = this.tail;
		int index = 0;
		while(aux!=null) {
			if(aux.v == v)
				return index;
			aux = aux.prev;
			index++;
		}
		return -1;
	}
	
	public int get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		Node aux = this.head;
		
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		
		return aux.v;
	}
	
	public boolean contains(int v) {
		return indexOf(v) != -1;
	}
	
	public Integer getFirst() {
	    if(this.isEmpty()) return null;
	    return this.head.v;
	}

	public Integer getLast() {
	    if(this.isEmpty()) return null;
	    return this.tail.v;
	}
	
	public int removeFirst() {
        
	    if (isEmpty()) throw new NoSuchElementException();
	        
	    int v = this.head.v;
	        
	    if (this.head.next == null) {
	        this.head = null;
	        this.tail = null;
	    } else {
	        this.head = this.head.next;
	        this.head.prev = null;
	    }
	        
	    size -= 1;
	    return v;
	}

	public int removeLast() {
        
	    if (isEmpty()) throw new NoSuchElementException();
	        
	    int v = this.head.v;
	        
	    if (this.head.next == null) {
	        this.head = null;
	        this.tail = null;
	    } else {
	        this.tail = this.tail.prev;
	        this.tail.next = null;
	    }
	        
	    size -= 1;
	    return v;
	}
	
	public boolean removeByValue(int v) {
	    Node aux = this.head;
	    for (int i = 0; i < this.size; i++) {
	        if (aux.v == v) {
	            if (i == 0) removeFirst();
	            else if (i == size - 1) removeLast();
	            else {
	                aux.prev.next = aux.next;
	                aux.next.prev = aux.prev;
	                size -= 1;
	            }
	            return true;
	        }
	        aux = aux.next;
	    }
	        
	    return false;
	}
	
	public int size() {
		return size;
	}
	
	public int remove(int index) {
	    if (index < 0 || index >= size)
	        throw new IndexOutOfBoundsException();
	    
	    if (index == 0) return removeFirst();
	    if (index == size - 1) return removeLast();
	    
	    Node aux = this.head;
	    for (int i = 0; i < index; i++)
	        aux = aux.next;
	    
	    aux.prev.next = aux.next;
	    aux.next.prev = aux.prev;
	    size -= 1;       
	    return aux.v;
	}
}

class Node {
	int v;
	Node next;
	Node prev;
	
	public Node(int v) {
		this.v = v;
		this.next = null;
		this.prev = null;
	}
}
