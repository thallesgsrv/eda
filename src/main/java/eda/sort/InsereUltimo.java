package eda.sort;

import java.util.*;

class InsereUltimo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] nums = sc.nextLine().split(" ");
		System.out.println(Arrays.toString(insereUltimo(nums)));
	}
	
	public static String[] insereUltimo(String[] v) {
		for(int i = v.length-1; i >= 0; i--) {
			int maior = i;
			for (int j = i-1; j >= 0; j--) {
				int a = Integer.parseInt(v[maior]); 
				int b = Integer.parseInt(v[j]);
				if (a < b){
					maior = j;
				}
			}
			String aux = v[i];
			v[i] = v[maior];
			v[maior] = aux;
		}
		return v;
	}

}
