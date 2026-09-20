package eda.recursivos;

import java.util.Scanner;

class BuscaBinaria {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("alg time sample");

		while (sc.hasNextLine()) {
			String linha = sc.nextLine().trim();

			if (linha.isEmpty()) {
				continue;
			}

			String[] nums = linha.split("\\s+");
			int[] valores = new int[nums.length];

			for (int i = 0; i < nums.length; i++) {
				valores[i] = Integer.parseInt(nums[i]);
			}

			long start = System.nanoTime();
			buscaBinaria(valores, 0, valores.length - 1, -1);
			long end = System.nanoTime();

			long time = end - start;

			System.out.println("busca-recursiva " + time + " " + valores.length);
		}
	}

	public static int buscaBinaria(int[] v, int inicio, int fim, int k) {
		if (inicio > fim) {
			return -1;
		}

		int mid = (inicio + fim) / 2;
		int n = v[mid];

		if (n == k) {
			return mid;
		}

		if (k > n) {
			return buscaBinaria(v, mid + 1, fim, k);
		}

		return buscaBinaria(v, inicio, mid - 1, k);
	}
}