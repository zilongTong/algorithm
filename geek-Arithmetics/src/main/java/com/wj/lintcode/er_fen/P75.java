package com.wj.lintcode.er_fen;

public class P75 {

	public int findPeak(int[] a) {
		if(a == null || a.length <= 2) {
			return -1;
		}
		int left = 0;
		int len = a.length;
		int right = len - 1;
		int mid = (left + right) / 2;
		while(mid > left && mid < right) {
			int prev = a[mid - 1];
			int v = a[mid];
			int next = a[mid + 1];
			if(prev > v) {//左边
				right = mid;
			} else if(next > v) {//右边
				left = mid;
			} else {
				return mid;
			}
			mid = (left + right) / 2;
		}
		return -1;
    }
	
	public static void main(String[] args) {
		System.out.println(new P75().findPeak(new int[]{1, 2, 1, 3, 4, 5, 7, 6}));
	}
}
