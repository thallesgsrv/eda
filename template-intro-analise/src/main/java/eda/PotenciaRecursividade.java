package eda;

import java.util.*;

class PotenciaRecursividade {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int e = Integer.parseInt(sc.nextLine());
		System.out.println(passoRecursivo(n,e));
	}
	
	public static int passoRecursivo(int n, int j) {
		if (j == 0) return 1;
		return n * passoRecursivo(n, j-1);
	}
}
