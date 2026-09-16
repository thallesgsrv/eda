package eda;

import java.util.*;

class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		System.out.println(calculaFibonacci(n));
	}
	
	public static int calculaFibonacci(int n) {
		if (n==0) return 0;
		if (n==1) return 1;
		return calculaFibonacci(n-1) + calculaFibonacci(n-2);
	}

}
