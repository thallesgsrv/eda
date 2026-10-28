package eda.questoes;

import java.util.Scanner;

public class InvertePilha {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pilha p = new Pilha(n);

        for (int i = 0; i < n; i++){
            p.push(sc.nextInt());
        }

        Pilha a = p.invertePilha();
        for (int i = 0; i < n; i++){
            System.out.println(a.pop());
        }
    }
}

class Pilha {
    private int topo;
    private int[] pilha;

    public Pilha(int capacidade){
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

    public Pilha invertePilha(){
        Pilha a = new Pilha(pilha.length);
        while (!isEmpty()){
            a.push(pop());
        }
        return a;
    }
}
