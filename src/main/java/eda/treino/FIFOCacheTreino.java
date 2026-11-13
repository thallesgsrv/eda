
package eda.treino;

public class FIFOCacheTreino {
    private int capacidade;
    private FifoTreino cache;

    public FIFOCacheTreino(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade inválida");
        }

        this.cache = new FifoTreino(capacidade);
        this.capacidade = capacidade;
    }

    public String getNextEviction() {
        if (cache.size() < capacidade) {
            return null;
        }
        return cache.peek();
    }

    public String get(String chave) {
        if (cache.contains(chave)) {
            return "hit";
        }

        cache.add(chave);
        return "miss";
    }
}

class FifoTreino {
    private int head;
    private int tail;
    private int size;
    private String[] fila;

    public FifoTreino(int capacidade) {
        this.head = 0;
        this.tail = -1;
        this.size = 0;
        this.fila = new String[capacidade];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= fila.length;
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Fila vazia");
        }
        return fila[head];
    }

    public int size() {
        return size;
    }

    public boolean contains(String x) {
        for (int i = 0; i < size; i++) {
            int index = (head + i) % fila.length;

            if (fila[index].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public void add(String c) {
        if (isFull()) {
            head = (head + 1) % fila.length;
        } else {
            size++;
        }

        tail = (tail + 1) % fila.length;
        fila[tail] = c;
    }

    public String remove() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Fila vazia");
        }

        String v = fila[head];
        head = (head + 1) % fila.length;
        size--;

        if (isEmpty()) {
            head = 0;
            tail = -1;
        }

        return v;
    }
}
