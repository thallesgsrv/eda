package eda.estruturas;

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
	
	// verifica se a lista esta vázia
	public boolean isEmpty() {
		return this.head == null;
	}
	
	// adiciona no final da lista
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
	
	// adiciona no começo da lista
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
	
	// adiciona no indice especifico
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
	
	// percorre a lista até encontrar o elemento e retorna o indice da primeira ocorrência do elemento
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
	
	// percorre a lista até encontrar o elemento e retorna o indice da ultima ocorrência do elemento 
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
	
	// retorna o elemento de acordo com o indice
	public int get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		Node aux = this.head;
		
		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}
		
		return aux.v;
	}
	
	// verifica se contém o elemento na lista
	public boolean contains(int v) {
		return indexOf(v) != -1;
	}
	
	// retorna o primeiro elemento da lista
	public Integer getFirst() {
	    if(this.isEmpty()) return null;
	    return this.head.v;
	}

	// retorna o ultimo elemento da lista
	public Integer getLast() {
	    if(this.isEmpty()) return null;
	    return this.tail.v;
	}
	
	
	// remove o primeiro elemento da lista
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

	// remove o ultimo elemento da lista
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
	
	// remove a primeira ocorrencia do elemento
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
	
	// retorna o tamanho da lista
	public int size() {
		return size;
	}
	
	
	// remove com base no indice
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

// classe dos nós 
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
