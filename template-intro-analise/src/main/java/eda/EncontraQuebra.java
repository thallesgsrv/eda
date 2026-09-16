package eda;

import java.util.Scanner;

class EncontraQuebra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] nums = sc.nextLine().split(" ");
		System.out.println(buscaRecursiva(nums,0, 1));
	}
	
	public static int buscaRecursiva(String[] n, int k, int i) {
		if(i>=n.length) return -1;
		if(Integer.parseInt(n[k]) > Integer.parseInt(n[i])) return i;
		return buscaRecursiva(n,k+1,i+1);
	} 

}
