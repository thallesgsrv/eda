package eda.estruturas;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementação de uma Tabela Hash com endereçamento fechado
 * (encadeamento) para resolução de colisões.
 *
 * Implementação simplificada, sem resize e rehash.
 *
 * @author Thalles Gabriel Saraiva de Lira Silva
 */

public class TabelaHash<K, V> {

    private ArrayList<Entry>[] tabela;
    private final int CAPACIDADE_DEFAULT = 20;

    /**
     * Cria uma tabela com capacidade default 20.
     */
    @SuppressWarnings("unchecked")
    public TabelaHash() {
        this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
    }

    /**
     * Cria uma tabela com a capacidade informada.
     */
    @SuppressWarnings("unchecked")
    public TabelaHash(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade inválida.");
        }

        this.tabela = new ArrayList[capacidade];
    }

    /**
     * Calcula o hash utilizando o método da divisão.
     */
    private int hash(K chave) {
        return Math.floorMod(chave.hashCode(), tabela.length);
    }

    /**
     * Retorna o índice da posição que contém a chave.
     */
    private int indiceDe(K chave) {

        int idx = hash(chave);

        if (tabela[idx] == null) {
            return -1;
        }

        for (Entry atual : tabela[idx]) {
            if (atual.getKey().equals(chave)) {
                return idx;
            }
        }

        return -1;
    }

    /**
     * Recupera o valor associado à chave.
     */
    @SuppressWarnings("unchecked")
    public V get(K chave) {

        int idx = indiceDe(chave);

        if (idx == -1) {
            return null;
        }

        for (Entry atual : tabela[idx]) {
            if (atual.getKey().equals(chave)) {
                return (V) atual.getValue();
            }
        }

        return null;
    }

    /**
     * Adiciona ou atualiza um par chave-valor na tabela.
     */
    public void put(K chave, V valor) {

        int idx = hash(chave);

        if (tabela[idx] == null) {
            tabela[idx] = new ArrayList<>();
        }

        for (Entry atual : tabela[idx]) {

            if (atual.getKey().equals(chave)) {
                atual.setValue(valor);
                return;
            }
        }

        tabela[idx].add(new Entry(chave, valor));
    }

    /**
     * Verifica se a chave está presente na tabela.
     */
    public boolean containsKey(K chave) {
        return indiceDe(chave) != -1;
    }

    /**
     * Verifica se determinado valor está presente na tabela.
     */
    public boolean containsValue(V valor) {

        for (ArrayList<Entry> lista : tabela) {

            if (lista != null) {

                for (Entry atual : lista) {
                    if (atual.getValue().equals(valor)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Remove o par cuja chave corresponde à chave informada.
     */
    @SuppressWarnings("unchecked")
    public V remove(K chave) {

        int idx = hash(chave);

        if (tabela[idx] == null) {
            return null;
        }

        Iterator<Entry> it = tabela[idx].iterator();

        while (it.hasNext()) {

            Entry atual = it.next();

            if (atual.getKey().equals(chave)) {
                it.remove();
                return (V) atual.getValue();
            }
        }

        return null;
    }
}

class Entry {

    private Object key;
    private Object value;

    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}