package eda.estruturas;

public class ArrayList {

	private int[] lista;
	public static final int CAPACIDADE_DEFAULT = 10;
	private int tamanho;

	public ArrayList() {
		this(CAPACIDADE_DEFAULT);
	}

	public ArrayList(int capacidade) {
		if (capacidade < 0) {
			throw new IllegalArgumentException("Capacidade inválida!");
		}

		this.lista = new int[capacidade];
		this.tamanho = 0;
	}

	public boolean add(int elem) {
		assegureCapacidade(this.tamanho + 1);
		this.lista[this.tamanho++] = elem;
		return true;
	}

	public void add(int index, int elem) {
		verificaIndexAdd(index);
		assegureCapacidade(this.tamanho + 1);
		shiftParaDireita(index);

		this.lista[index] = elem;
		this.tamanho++;
	}

	public void set(int index, int elem) {
		verificaIndexExistente(index);
		this.lista[index] = elem;
	}

	private void shiftParaDireita(int index) {
		for (int i = this.tamanho; i > index; i--) {
			this.lista[i] = this.lista[i - 1];
		}
	}

	private void shiftParaEsquerda(int index) {
		for (int i = index; i < this.tamanho - 1; i++) {
			this.lista[i] = this.lista[i + 1];
		}
	}

	private void assegureCapacidade(int capacidadePretendida) {
		if (capacidadePretendida > this.lista.length) {
			int novaCapacidade = Math.max(
					this.lista.length * 2,
					capacidadePretendida
			);


			if (novaCapacidade == 0) {
				novaCapacidade = 1;
			}

			resize(novaCapacidade);
		}
	}

	private void resize(int novaCapacidade) {
		int[] novaLista = new int[novaCapacidade];

		for (int i = 0; i < this.tamanho; i++) {
			novaLista[i] = this.lista[i];
		}

		this.lista = novaLista;
	}

	public int remove(int index) {
		verificaIndexExistente(index);

		int value = this.lista[index];
		shiftParaEsquerda(index);
		this.tamanho--;

		return value;
	}

	public boolean removeByValue(int value) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.lista[i] == value) {
				remove(i);
				return true;
			}
		}

		return false;
	}

	private void verificaIndexAdd(int index) {
		if (index < 0 || index > this.tamanho) {
			throw new IndexOutOfBoundsException("Índice inválido!");
		}
	}

	private void verificaIndexExistente(int index) {
		if (index < 0 || index >= this.tamanho) {
			throw new IndexOutOfBoundsException("Índice inválido!");
		}
	}

	public int get(int index) {
		verificaIndexExistente(index);
		return this.lista[index];
	}

	public int indexOf(int value) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.lista[i] == value) {
				return i;
			}
		}

		return -1;
	}

	public boolean contains(int value) {
		return indexOf(value) != -1;
	}

	public int size() {
		return this.tamanho;
	}

	public boolean isEmpty() {
		return this.tamanho == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");

		for (int i = 0; i < this.tamanho; i++) {
			if (i > 0) {
				sb.append(", ");
			}

			sb.append(this.lista[i]);
		}

		sb.append("]");
		return sb.toString();
	}
}