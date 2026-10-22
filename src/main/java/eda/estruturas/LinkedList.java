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

	// verifica se a lista está vazia
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
			nn.next = this.head;
			this.head.prev = nn;
			this.head = nn;
		}

		size++;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node aux = this.head;

		while (aux != null) {
			if (sb.length() > 0) {
				sb.append(", ");
			}

			sb.append(aux.v);
			aux = aux.next;
		}

		return sb.toString();
	}


	// adiciona em um índice específico
	public void add(int index, int v) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			addFirst(v);
			return;
		}

		if (index == size) {
			addLast(v);
			return;
		}

		Node aux = this.head;

		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}

		Node nn = new Node(v);

		nn.prev = aux.prev;
		nn.next = aux;

		aux.prev.next = nn;
		aux.prev = nn;

		size++;
	}

	// retorna o índice da primeira ocorrência
	public int indexOf(int v) {
		Node aux = this.head;
		int index = 0;

		while (aux != null) {
			if (aux.v == v) {
				return index;
			}

			aux = aux.next;
			index++;
		}

		return -1;
	}

	// retorna o índice da última ocorrência
	public int lastIndexOf(int v) {
		Node aux = this.tail;
		int index = size - 1;

		while (aux != null) {
			if (aux.v == v) {
				return index;
			}

			aux = aux.prev;
			index--;
		}

		return -1;
	}

	// retorna o elemento de acordo com o índice
	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		Node aux;

		// percorre pelo lado mais próximo
		if (index < size / 2) {
			aux = this.head;

			for (int i = 0; i < index; i++) {
				aux = aux.next;
			}
		} else {
			aux = this.tail;

			for (int i = size - 1; i > index; i--) {
				aux = aux.prev;
			}
		}

		return aux.v;
	}

	// verifica se contém o elemento
	public boolean contains(int v) {
		return indexOf(v) != -1;
	}

	// retorna o primeiro elemento
	public Integer getFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return this.head.v;
	}

	// retorna o último elemento
	public Integer getLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return this.tail.v;
	}

	// remove o primeiro elemento
	public int removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int v = this.head.v;

		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
			this.head.prev = null;
		}

		size--;
		return v;
	}

	// remove o último elemento
	public int removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int v = this.tail.v;

		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = this.tail.prev;
			this.tail.next = null;
		}

		size--;
		return v;
	}

	// remove a primeira ocorrência do valor
	public boolean removeByValue(int v) {
		Node aux = this.head;

		while (aux != null) {
			if (aux.v == v) {
				if (aux == this.head) {
					removeFirst();
				} else if (aux == this.tail) {
					removeLast();
				} else {
					aux.prev.next = aux.next;
					aux.next.prev = aux.prev;
					size--;
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

	// remove pelo índice
	public int remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			return removeFirst();
		}

		if (index == size - 1) {
			return removeLast();
		}

		Node aux = this.head;

		for (int i = 0; i < index; i++) {
			aux = aux.next;
		}

		aux.prev.next = aux.next;
		aux.next.prev = aux.prev;

		size--;
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
