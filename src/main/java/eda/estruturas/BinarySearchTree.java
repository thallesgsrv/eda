package eda.estruturas;

public class BinarySearchTree{
    private No root;
    private int tamanho;

    public BinarySearchTree(){

    }

    private static class No {
        int value;
        No left;
        No right;
        No parent;

        No(int v){
            this.value = v;
            this.right = null;
            this.left = null;
            this.parent = null;
        }

        void setParent(No parent){
            this.parent = parent;
        }
    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean get(int v){
        No aux = this.root;
        while (aux != null){
            if (aux.value == v){
                return true;
            }
            if (v > aux.value){
                aux = aux.right;
            } else {
                aux = aux.left;
            }

        }
    return false;
    }
    
    public void add(int valor) {
    	if (root == null) {
    		this.root = new No(valor);
    		tamanho++;
    		return;
    	}
    	
    	No aux = this.root;
    	
    	while (true) {
    		if (valor < aux.value) {
    			if (aux.left == null) {
    				aux.left = new No(valor);
    				tamanho++;
    				return;
    			}
    			aux = aux.left;
    		} else {
    			if (aux.right == null) {
    				aux.right = new No(valor);
    				tamanho++;
    				return;
    			}
    			aux = aux.right;
    		}
    	}
}
}
