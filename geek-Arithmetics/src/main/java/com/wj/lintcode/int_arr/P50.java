package com.wj.lintcode.int_arr;

import java.util.ArrayList;

public class P50 {

	public ArrayList<Long> productExcludeItself(ArrayList<Integer> a) {
		ArrayList<Long> result = new ArrayList<>(0);
		if(a == null || a.size() < 1) {
			return result;
		}
		int len = a.size();
		for(int i = 0; i < len; i ++) {
			result.add(1L);
		}
		for(int i = 0; i < len; i ++) {
			for(int j = 0; j < len; j ++) {
				if(i == j) {
					if(result.get(j) == null) {
						result.set(j, 1L);
					}
				} else {
					result.set(j, result.get(j) * a.get(i));
				}
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(new P50().productExcludeItself(list));
	}
}
