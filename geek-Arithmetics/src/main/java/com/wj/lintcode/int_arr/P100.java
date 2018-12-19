package com.wj.lintcode.int_arr;

public class P100 {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		int current = nums[0];
		int count = 1;
		for(int i = 0, len = nums.length; i < len; i ++) {
			int v = nums[i];
			if(v > current) {
				nums[count] = v;
				count ++;
				current = v;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new P100().removeDuplicates(new int[] { 1, 1, 2 }));
	}
}
