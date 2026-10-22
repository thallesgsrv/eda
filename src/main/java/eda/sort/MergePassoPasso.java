package eda.sort;

import java.util.*;

class MergePassoPasso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] v = sc.nextLine().trim().split("\\s+");
		int[] nums = new int[v.length];

		for (int i = 0; i < v.length; i++) {
			nums[i] = Integer.parseInt(v[i]);
		}

		mergeSort(nums, 0, nums.length - 1);

		System.out.println(Arrays.toString(nums));
		sc.close();
	}

	public static void mergeSort(int[] v, int inicio, int fim) {
		if (inicio >= fim) {
			return;
		}

		int meio = inicio + (fim - inicio) / 2;

		mergeSort(v, inicio, meio);
		mergeSort(v, meio + 1, fim);

		merge(v, inicio, meio, fim);
	}

	public static void merge(int[] v, int inicio, int meio, int fim) {
		int[] esquerda = Arrays.copyOfRange(v, inicio, meio + 1);
		int[] direita = Arrays.copyOfRange(v, meio + 1, fim + 1);

		int i = 0;
		int j = 0;
		int k = inicio;

		while (i < esquerda.length && j < direita.length) {
			if (esquerda[i] <= direita[j]) {
				v[k++] = esquerda[i++];
			} else {
				v[k++] = direita[j++];
			}
		}

		while (i < esquerda.length) {
			v[k++] = esquerda[i++];
		}

		while (j < direita.length) {
			v[k++] = direita[j++];
		}
	}
}
