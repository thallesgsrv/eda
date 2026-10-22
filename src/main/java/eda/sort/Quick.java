package eda.sort;

import java.util.*;

class QuickPassoPasso {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] v = sc.nextLine().trim().split("\\s+");
		int[] nums = new int[v.length];

		for (int i = 0; i < v.length; i++) {
			nums[i] = Integer.parseInt(v[i]);
		}

		quickSort(nums, 0, nums.length - 1);

		System.out.println(Arrays.toString(nums));
		sc.close();
	}

	public static void quickSort(int[] v, int inicio, int fim) {
		if (inicio >= fim) {
			return;
		}

		int pivo = particionar(v, inicio, fim);

		quickSort(v, inicio, pivo - 1);
		quickSort(v, pivo + 1, fim);
	}

	public static int particionar(int[] v, int inicio, int fim) {
		int pivo = v[fim];
		int i = inicio - 1;

		for (int j = inicio; j < fim; j++) {
			if (v[j] <= pivo) {
				i++;

				int temp = v[i];
				v[i] = v[j];
				v[j] = temp;
			}
		}

		int temp = v[i + 1];
		v[i + 1] = v[fim];
		v[fim] = temp;

		return i + 1;
	}
}
