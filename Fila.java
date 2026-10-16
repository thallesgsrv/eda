package eda;

public class Fila {
	
	private String[] fila;
	private int head;
	private int tail;
	private int size;

	public Fila(int capacidade) {
		this.fila = new String[capacidade];
		this.head = -1;
		this.tail = -1;
		this.size = 0;
	}
	
	public boolean isFull() {
		return this.size >= fila.length;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void addLast(String elem) {
		if (!isFull()) size++;
		if (isEmpty	()) head = 0;
		
		if (isFull())
			this.head = (this.head + 1) % this.fila.length;
		this.tail = (this.tail+1) % this.fila.length;
		this.fila[tail] = elem;
	}
	
	public String removeFirst() {
		if (isEmpty()) throw new RuntimeException("Fila vazia!");
		String value = this.fila[this.head];
		
		if (this.head == this.tail) {
			this.head--;
			this.tail--;
		} else {
			this.head = (this.head+1) % this.fila.length;
		}
		this.size--;
		return value;
	}
}
