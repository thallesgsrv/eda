package eda.recursivos;

import java.util.*;

class InsertionRecursivo {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] v = sc.nextLine().split(" ");
		int[] nums = new int[v.length];
		for (int i = 0; i < v.length; i++) {
			nums[i] = Integer.parseInt(v[i]);
		}
		insertion(nums, 1);
	}
	
	public static void insertion(int[] nums, int i) {
		if (i >= nums.length) return;
		int j = i;
		while (j> 0 && nums[j] < nums[j-1]) {
			swap(nums, j, j-1);
			j--;
		}
		System.out.println(Arrays.toString(nums));
		insertion(nums, i+1);
	}
	
	public static void swap(int[] nums, int j, int n){
		int temp = nums[j];
		nums[j] = nums[n];
		nums[n] = temp;
	}
	 
	

}
