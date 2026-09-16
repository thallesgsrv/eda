package eda;

import java.util.Scanner;

class BuscaBinaria {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("alg time sample");
		while (sc.hasNextLine()) {
			String linha = sc.nextLine().trim();
			
			if(linha.isEmpty()) {
				continue;
			}
			String[] nums = linha.split("\\s+");;
		long start = System.nanoTime();
		buscaBinaria(nums, 0, nums.length-1, -1);
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("busca-recursiva " + (time) + " " + nums.length);
		}
	}
	
	public static int buscaBinaria(String[] v, int inicio, int fim, int k) {
		if (inicio>fim) return -1;
		int mid = (inicio+fim)/2;
		int n = Integer.parseInt(v[mid]);
		if (n == k) return mid;
		if (k > n) {
			return buscaBinaria(v, mid+1, fim, k);
		}
		return buscaBinaria(v, inicio, mid-1, k);
	}
}

