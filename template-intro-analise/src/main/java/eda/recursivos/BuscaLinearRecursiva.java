package eda.recursivos;

import java.util.*;

class BuscaLinearRecursiva {

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
			buscaRecursiva(nums, -1, 0);
			long end = System.nanoTime();
			long time = end - start;
			System.out.println("busca-recursiva " + (time) + " " + nums.length);
		 }
	}
	
	public static int buscaRecursiva(String[] n, int k, int i) {
		if(i>=n.length) return -1;
		if(Integer.parseInt(n[i]) == k) return i;
		return buscaRecursiva(n,k,i+1);
	}

}
