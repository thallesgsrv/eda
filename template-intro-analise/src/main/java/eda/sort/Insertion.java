package eda.sort;

public class Insertion<T extends Comparable<T>> implements Sorting<T>  {
	@Override
	public void sort(T[] v) {
		for (int i = 1; i < v.length; i++) {
			T key = v[i];
			int j = i-1;
			while (j >= 0 && v[i].compareTo(key) > 0) {
				v[j+1] = v[j];
				j--;
			}
			v[i+1] = key;
		}
	}

}
