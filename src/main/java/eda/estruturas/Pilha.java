package eda.estruturas;

public class Pilha {

	private int topo;
	private String[] pilha;
	
	
	public Pilha(int capacidade) {
		this.topo = -1;
		this.pilha = new String[capacidade];
	}
	
	private boolean isEmpty() {
		return this.topo == -1;
	}
	
	private boolean isFull() {
		return this.topo +1  == this.pilha.length;
	}
	
	public String peek() {
		if (!isEmpty()) throw new RuntimeException("Sem elementos na pilha!");
		return this.pilha[this.topo--];
	}
	
	public void push(String elemento) {
		if (isFull()) throw new RuntimeException("Pilha cheia!");
		this.pilha[this.topo++] = elemento;
	}
	
	public String pop() {
		if (isEmpty()) throw new RuntimeException("Sem elementos na pilha!");
		return this.pilha[this.topo];
	}
}
