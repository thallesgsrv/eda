package eda.questoes;

import java.util.*;

public class OrdenaPilhaInvertendo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Pilha p = new Pilha(n);

        for (int i = 0; i < n; i++) {
            p.push(sc.nextInt());
        }

        p.ordenaPilhaInvertendo();

        System.out.println("-");

        while (!p.isEmpty()) {
            System.out.println(p.pop());
        }

        sc.close();
    }
}

class Pilha {
    private int topo;
    private int[] pilha;

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return this.topo + 1 >= this.pilha.length;
    }

    public void push(int elem) {
        if (isFull()) throw new RuntimeException("Pilha cheia!");
        this.pilha[++this.topo] = elem;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Pilha vázia!");
        return this.pilha[this.topo--];
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Pilha vázia!");
        return this.pilha[this.topo];
    }

    public int getMax(int index) {
        if (isEmpty() || index < 0 || index > topo)
            throw new RuntimeException("Índice inválido!");

        Pilha aux = new Pilha(index + 1);
        int max = pop();
        int idx = 0;
        aux.push(max);
        for (int i = 1; i <= index; i++) {
            int elem = pop();
            aux.push(elem);
            if (elem > max) {
                max = elem;
                idx = i;
            }
        }
        while (!aux.isEmpty()) {
            push(aux.pop());
        }
        return idx;
    }

    public void inverte(int index) {
        if (isEmpty() || index < 0 || index > topo)
            throw new RuntimeException("Índice inválido!");

        Pilha aux = new Pilha(index + 1);
        Pilha aux2 = new Pilha(index + 1);

        for (int i = 0; i <= index; i++) {
            aux.push(pop());
        }

        while (!aux.isEmpty()) {
            aux2.push(aux.pop());
        }

        while (!aux2.isEmpty()) {
            push(aux2.pop());
        }
    }

    public void ordenaPilhaInvertendo() {
        for (int i = topo; i > 0; i--) {
            int idx = getMax(i);

            if (idx != 0) {
                inverte(idx);
            }

            if (i != 0) {
                inverte(i);
            }
        }
    }
}
