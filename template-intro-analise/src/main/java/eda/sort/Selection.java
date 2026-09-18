package eda.sort;

public class Selection<T extends Comparable<T>> implements Sorting<T> {
	@Override
	public void sort(T[] v) {
		for (int i = 0; i < v.length-1; i++) {
			int menor = i;
			for(int j = i+1; j < v.length; j++) {
				if (v[j].compareTo(v[menor]) < 0) {
					menor = j;
				}
			}
			T aux = v[i];
			v[i] = v[menor];
			v[menor] = aux;
		}
	}
}