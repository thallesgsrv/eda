package eda.treino;

import java.util.*;

public class HashTreino {

    private ArrayList<ArrayList<Pessoa>> tabela;
    private static final int CAPACIDADE_DEFAULT = 20;
    private int size;

    public HashTreino(){
        this.size = 0;
        this.tabela = new ArrayList<>();
        for (int i = 0; i < CAPACIDADE_DEFAULT; i++) {
            tabela.add(null);
            }
    }

    public HashTreino(int c){
        this.size = 0;
        this.tabela = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            tabela.add(null);
        }
    }

    public int hash (Object chave) { return Math.floorMod(chave.hashCode(), tabela.size());}

    public int indiceDe(Object chave){
        int idx = hash(chave);

        if (tabela.get(idx) == null){
            return -1;
        }

        for (Pessoa p : tabela.get(idx)){
            if(p.getChave().equals(chave)){
                return idx;
            }
        }
        return -1;
    }

    public Object get(Object chave) {
        int idx = indiceDe(chave);

        if (idx == -1){
            return null;
        }

        for (Pessoa p : tabela.get(idx)) {
            if (p.getChave().equals(chave)) {
                return p.getValor();
            }
        }
        return null;
    }

    public void put(Object chave, Object value) {
        int idx = hash(chave);

        if (tabela.get(idx) == null) {
            tabela.set(idx, new ArrayList<Pessoa>());
        }

        for (Pessoa p : tabela.get(idx)) {
            if (p.getChave().equals(chave)) {
                p.setValor(value);
                return;
            }
        }
        tabela.get(idx).add(new Pessoa(chave, value));
        size++;
    }

    public Object remove(Object chave){
        int idx = hash(chave);

        if (tabela.get(idx) == null){
            return null;
        }

        Iterator<Pessoa> it = tabela.get(idx).iterator();

        while(it.hasNext()){

            Pessoa atual = it.next();

            if(atual.getChave().equals(chave)){
                it.remove();
                size--;
                return (Object) atual.getValor();
            }
        }
        return null;
    }

    public int size() {return size;}

    public boolean isEmpty(){return size == 0;}

    public boolean containsKey(Object chave) {
        return indiceDe(chave) != -1;
    }

}

class Pessoa{
    private Object chave;
    private Object valor;

    public Pessoa(Object chave, Object valor){
        this.chave = chave;
        this.valor = valor;
    }

    public Object getValor(){ return valor;}

    public void setValor(Object newValue){ this.valor = newValue; }

    public Object getChave(){ return chave;}
}
