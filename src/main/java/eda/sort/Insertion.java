
package eda.sort;

public class Insertion {
	public void sort(int[] v) {
		for (int i = 1; i < v.length; i++) {
			int key = v[i];
			int j = i - 1;

			while (j >= 0 && v[j] > key) {
				v[j + 1] = v[j];
				j--;
			}

			v[j + 1] = key;
		}
	}
}
