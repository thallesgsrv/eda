package eda.questoes;

import java.util.Scanner;

public class InvertePilhaDois {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PilhaDois p = new PilhaDois(n);

        for (int i = 0; i < n; i++){
            p.push(sc.nextInt());
        }

        PilhaDois a = p.invertePilha();
        for (int i = 0; i < n; i++){
            System.out.println(a.pop());
        }
    }
}

class PilhaDois {
    private int topo;
    private int[] pilha;

    public PilhaDois(int capacidade){
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty(){
        return this.topo == -1;
    }

    public boolean isFull(){
        return this.topo+1 == this.pilha.length;
    }

    public int pop(){
        if(isEmpty()) throw new IllegalArgumentException("Pilha vazia!");
        return this.pilha[this.topo--];
    }

    public void push(int elem){
        if(isFull()) throw new RuntimeException("Pilha cheia!");
        this.pilha[++this.topo] = elem;
    }

    public int peak(){
        if(isEmpty()) throw new IllegalArgumentException("Pilha vazia!");
        return this.pilha[this.topo];
    }

    public PilhaDois invertePilha(){
        PilhaDois a = new PilhaDois(pilha.length);
        while (!isEmpty()){
            a.push(pop());
        }
        return a;
    }
}
