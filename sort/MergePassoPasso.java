package eda.sort;

import java.util.*;

class MergePassoPasso {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] v = sc.nextLine().split(" ");
		int[] nums = new int[v.length];
		for (int i = 0; i < v.length; i++) {
			nums[i] = Integer.parseInt(v[i]);
		}
		
		couting(nums, max(v), min(v));
		System.out.println(Arrays.toString(nums));

	}
	public static void radix(int[] v, int exp) {
		for(int i = 0; i < exp; i++) {
			couting(v,)
		}
	}
	
	public static int[] couting(int[] v, int k, int l) {
		int[] c = new int[k-l+1];
		
		for(int i = 0; i <= v.length; i++) {
			c[v[i]-l] += 1;
		}
		
		for(int i = 1; i < c.length; i++) {
			c[i] += c[i-1];
		}
		
		int[] saida = new int[v.length];
		for(int i = v.length-1; i >= 0; i--) {
			saida[c[v[i]-l]-1] = v[i];
			c[v[i-l]]--; 
		}
		return saida;
		
	}
	
	public static int min(int[]v) {
		int min = v[0];
		for (int i = 0; i < v.length; i++) {
			if (v[i] < min) min = v[i];
		}
		return min;
	}
	
	public static int max(int[]v) {
		int max = v[0];
		for (int i = 0; i < v.length; i++) {
			if (v[i] > max) max = v[i];
		}
		return max;
	}
}
