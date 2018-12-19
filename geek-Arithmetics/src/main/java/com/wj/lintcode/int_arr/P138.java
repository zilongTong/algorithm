package com.wj.lintcode.int_arr;

import java.util.ArrayList;

public class P138 {
	
	public ArrayList<Integer> subarraySum(int[] nums) {
		if(nums == null || nums.length < 1) {
			return new ArrayList<>(0);
		}
		ArrayList<Integer> list = new ArrayList<>();
		int len = nums.length;
		
		int sum = 0;
		for(int i = 0; i < len; i ++) {
			sum = nums[i];
			for(int j = i + 1; j < len; j ++) {
				sum += nums[j];
				if(sum == 0) {
					list.add(i);
					list.add(j);
					return list;
				}
			}
			if(nums[i] == 0) {
				list.add(i);
				list.add(i);
			}
		}
		
		return list;
    }
	

	public static void main(String[] args) {
		P138 p = new P138();
		
		System.out.println(p.subarraySum(new int[]{4,10,13,4,-1,0,3,3,5}));
	}
}
