
package eda.estruturas;

import java.util.ArrayList;
import java.util.Iterator;

public class TabelaHashDois<K, V> {

    // Vetor em que cada posição pode armazenar uma lista de pares chave/valor.
    private ArrayList<Teste<K, V>>[] tabela;

    // Capacidade padrão da tabela.
    private static final int CAPACIDADE_DEFAULT = 20;

    // Construtor sem parâmetros: utiliza a capacidade padrão.
    @SuppressWarnings("unchecked")
    public TabelaHashDois() {

        // Cria o vetor de ArrayLists.
        this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
    }

    // Construtor que permite definir a capacidade.
    @SuppressWarnings("unchecked")
    public TabelaHashDois(int v) {

        // Impede uma capacidade inválida.
        if (v <= 0) {
            throw new IllegalArgumentException("Capacidade inválida!");
        }

        // Cria o vetor com a capacidade informada.
        this.tabela = new ArrayList[v];
    }

    // Calcula o índice da chave na tabela.
    public int hash(K key) {

        // floorMod garante um índice entre 0 e tabela.length - 1.
        return Math.floorMod(key.hashCode(), tabela.length);
    }

    // Procura uma chave e retorna o índice onde ela está.
    // Se não encontrar, retorna -1.
    public int indiceDe(K key) {

        // Calcula a posição da chave na tabela.
        int i = hash(key);

        // Se não existe lista nessa posição, a chave não está na tabela.
        if (tabela[i] == null) {
            return -1;
        }

        // Percorre todos os elementos da lista daquela posição.
        for (Teste<K, V> atual : tabela[i]) {

            // Compara a chave armazenada com a chave procurada.
            if (atual.getKey().equals(key)) {
                return i;
            }
        }

        // Não encontrou a chave.
        return -1;
    }

    // Busca o valor associado a uma chave.
    public V get(K key) {

        // Primeiro verifica se a chave existe.
        int i = indiceDe(key);

        // Se não encontrou, retorna null.
        if (i == -1) {
            return null;
        }

        // Percorre a lista da posição encontrada.
        for (Teste<K, V> atual : tabela[i]) {

            // Procura o par que possui a chave desejada.
            if (atual.getKey().equals(key)) {

                // Retorna o valor associado à chave.
                return atual.getValue();
            }
        }

        return null;
    }

    // Insere uma chave e um valor na tabela.
    public void put(K key, V value) {

        // Descobre em qual posição a chave deve ficar.
        int i = hash(key);

        // Se ainda não existe uma lista nessa posição,
        // cria uma nova lista.
        if (tabela[i] == null) {
            tabela[i] = new ArrayList<>();
        }

        // Percorre a lista para verificar se a chave já existe.
        for (Teste<K, V> atual : tabela[i]) {

            // Se a chave já existe, atualiza seu valor.
            if (atual.getKey().equals(key)) {
                atual.setValue(value);

                // Interrompe o método para não duplicar a chave.
                return;
            }
        }

        // Se a chave não existia, adiciona um novo par.
        tabela[i].add(new Teste<>(key, value));
    }

    // Remove uma chave e retorna o valor que estava associado a ela.
    public V remove(K key) {

        // Calcula o índice da chave.
        int i = hash(key);

        // Se não existe lista nessa posição, não há o que remover.
        if (tabela[i] == null) {
            return null;
        }

        // Cria um Iterator para percorrer e remover elementos da lista.
        Iterator<Teste<K, V>> t = tabela[i].iterator();

        // Percorre enquanto existirem elementos.
        while (t.hasNext()) {

            // Obtém o próximo elemento da lista.
            Teste<K, V> atual = t.next();

            // Verifica se encontrou a chave procurada.
            if (atual.getKey().equals(key)) {

                // Guarda o valor antes de remover o elemento.
                V valor = atual.getValue();

                // Remove o elemento usando o Iterator.
                t.remove();

                // Retorna o valor que foi removido.
                return valor;
            }
        }

        // A chave não foi encontrada.
        return null;
    }
}

// Classe responsável por armazenar cada par chave/valor.
class Teste<K, V> {

    // Chave do elemento.
    private K key;

    // Valor associado à chave.
    private V value;

    // Construtor que recebe chave e valor.
    public Teste(K k, V v) {
        this.key = k;
        this.value = v;
    }

    // Retorna a chave.
    public K getKey() {
        return key;
    }

    // Retorna o valor.
    public V getValue() {
        return value;
    }

    // Atualiza o valor.
    public void setValue(V v) {
        this.value = v;
    }
}
