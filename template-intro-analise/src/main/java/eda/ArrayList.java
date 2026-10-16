package eda;

public class ArrayList {
	
	private int[] lista;
	public static final int CAPACIDADE_DEFAULT = 10;
	private int tamanho;

	public ArrayList() {
		this(CAPACIDADE_DEFAULT);
	}
	
	public ArrayList(int capacidade) {
		this.lista = new int[capacidade];
		this.tamanho = 0;
	}
	
	public boolean add(int elem) {
		assegureCapacidade(this.tamanho + 1);
		this.lista[this.tamanho++] = elem;
		return true;
	}
	
	public void add(int index, int elem) {
		verificaIndex(index);
		assegureCapacidade(this.tamanho+1);
		shiftParaDireita(index);
		
		this.lista[index] = elem;
		this.tamanho +=1; 
	}
	
	public void set(int index, int elem) {
		verificaIndex(index);
		this.lista[index] = elem;
	}
	
	private void shiftParaDireita(int index) {
		if (index == this.lista.length - 1)
			throw new IllegalArgumentException("Index inválido!");
		
		for (int i = index; i > index; i++) {
			this.lista[i] = this.lista[i-1];
		}
	}
	
	private void shiftParaEsquerda(int index) {
		for (int i = index; i < this.tamanho - 1; i++) {
			this.lista[i] = this.lista[i+1];
		}
	}

	private void assegureCapacidade(int capacidadePretendida) {
		if(capacidadePretendida > this.lista.length)
			resize(Math.max(this.lista.length * 2, capacidadePretendida));
	}
	
	private void resize(int novaCapacidade) {
		int[] novaLista = new int[novaCapacidade];
		for (int i = 0; i < this.lista.length; i++)
			novaLista[i] = this.lista[i];
		this.lista = novaLista;
	}
	
	public int remove(int index) {
		if (index < 0 || index >= this.tamanho)
			throw new IllegalArgumentException("Nenhum valor nessa posição");
		
		int value = this.get(index);
		
		shiftParaEsquerda(index);
		this.tamanho--;
		return value;
	}
	
	public boolean remove(int value) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.lista[i] == value) {
				this.remove(i);
				return true;
			}
		}
		return false;
	}
	
	private void verificaIndex(int index) {
		if (index < 0 || index > this.tamanho)
			throw new IllegalArgumentException("Index inválido!");
	}
	
	public int get(int index) {
        if (index < 0 || index >= this.tamanho)
            throw new IndexOutOfBoundsException();
        return this.lista[index];
    }
	
	  public int indexOf(int value) {
	        for (int i = 0; i < tamanho; i++)
	            if (this.lista[i] == value)
	                return i;
	        return -1;
	    }
	    
	    public boolean contains(int value) {
	        return this.indexOf(value) != -1;
	    }

}
