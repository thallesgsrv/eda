package eda.estruturas;

public class FIFOCache {

    // Guarda a fila que será utilizada para armazenar as chaves.
    private Fifo cache;

    // Guarda a capacidade máxima permitida no cache.
    private int capacidade;

    // Construtor da classe FIFOCache.
    public FIFOCache(int capacidade) {

        // Impede que o cache tenha capacidade zero ou negativa.
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade inválida!");
        }

        // Armazena a capacidade recebida.
        this.capacidade = capacidade;

        // Cria uma fila com a capacidade definida.
        this.cache = new Fifo(capacidade);
    }

    /*
     * Verifica se uma chave já está armazenada no cache.
     *
     * Se encontrar a chave, retorna "hit".
     * Se não encontrar, adiciona a chave e retorna "miss".
     */
    public String get(String chave) {

        // Verifica se a chave já existe na fila.
        if (cache.contains(chave)) {

            // A chave já estava armazenada.
            // Portanto, ocorreu um hit.
            return "hit";
        }

        // Se chegou aqui, a chave não estava no cache.
        // Adiciona a chave na fila.
        cache.addFila(chave);

        // Como a chave não existia, ocorreu um miss.
        return "miss";
    }

    /*
     * Retorna qual elemento será removido caso outro elemento
     * precise entrar no cache.
     */
    public String getNextEviction() {

        // Se a quantidade de elementos for menor que a capacidade,
        // ainda existe espaço disponível.
        if (cache.size() < capacidade) {
            return null;
        }

        // Se estiver cheio, retorna o elemento mais antigo.
        // peek() consulta sem remover.
        return cache.peek();
    }

    // Retorna a quantidade de elementos armazenados no cache.
    public int size() {
        return cache.size();
    }
}



class Fifo {

    // Índice do primeiro elemento da fila (o mais antigo).
    private int head;

    // Índice do último elemento da fila (o mais recente).
    private int tail;

    // Quantidade atual de elementos armazenados na fila.
    private int size;

    // Vetor que armazena os elementos da fila.
    private String[] fila;

    // Construtor que recebe a capacidade máxima da fila.
    public Fifo(int capacidade) {

        // Impede a criação de uma fila com capacidade inválida.
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade inválida!");
        }

        // Cria o vetor com o tamanho definido pelo usuário.
        this.fila = new String[capacidade];

        // Inicialmente, a fila começa vazia.
        this.head = 0;

        // -1 indica que ainda não existe último elemento.
        this.tail = -1;

        // A fila começa com zero elementos.
        this.size = 0;
    }

    // Adiciona um elemento no final da fila.
    public void addFila(String v) {

        // Verifica se a fila já atingiu sua capacidade máxima.
        if (isFull()) {

            // Se estiver cheia, avança o head.
            // Isso significa que o elemento mais antigo será descartado.
            this.head = (this.head + 1) % fila.length;

        } else {

            // Se não estiver cheia, aumenta a quantidade de elementos.
            this.size++;
        }

        // Avança o tail para a próxima posição disponível.
        // O operador % faz a fila voltar ao início do vetor
        // quando chega à última posição.
        this.tail = (this.tail + 1) % fila.length;

        // Armazena o novo elemento na posição indicada por tail.
        this.fila[tail] = v;
    }

    // Remove e retorna o elemento mais antigo da fila.
    public String remove() {

        // Não é possível remover elementos de uma fila vazia.
        if (isEmpty()) {
            throw new IllegalArgumentException("Fila vazia!");
        }

        // Guarda o elemento que está no início da fila.
        String v = fila[head];

        // Avança o head para o próximo elemento.
        this.head = (this.head + 1) % fila.length;

        // Diminui a quantidade de elementos.
        this.size--;

        // Se a fila ficou vazia, restaura os índices iniciais.
        if (isEmpty()) {
            this.head = 0;
            this.tail = -1;
        }

        // Retorna o elemento que foi removido.
        return v;
    }

    // Verifica se a quantidade de elementos chegou à capacidade máxima.
    public boolean isFull() {
        return size == fila.length;
    }

    // Verifica se a fila não possui nenhum elemento.
    public boolean isEmpty() {
        return size == 0;
    }

    // Retorna a quantidade atual de elementos.
    public int size() {
        return size;
    }

    // Consulta o primeiro elemento sem removê-lo.
    public String peek() {

        // Se estiver vazia, não existe primeiro elemento.
        if (isEmpty()) {
            return null;
        }

        // Retorna o elemento mais antigo sem alterar a fila.
        return fila[head];
    }

    // Verifica se determinada chave está presente na fila.
    public boolean contains(String chave) {

        // Percorre somente as posições que possuem elementos.
        for (int i = 0; i < size; i++) {

            // Calcula a posição considerando que a fila é circular.
            int index = (head + i) % fila.length;

            // Compara o elemento atual com a chave procurada.
            if (fila[index].equals(chave)) {
                return true;
            }
        }

        // Se terminou o percurso sem encontrar, retorna false.
        return false;
    }
}
