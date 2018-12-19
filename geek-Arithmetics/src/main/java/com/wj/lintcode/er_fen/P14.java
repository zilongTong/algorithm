package com.wj.lintcode.er_fen;

public class P14 {
	public int findFirst(int[] a, int target, int index) {
		while(index > 0 && a[index - 1] == target) {
			index --;
		}
		return index;
	}
	public int binarySearch(int[] a, int target) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int right = a.length - 1;
		int left = 0;
		int mid = (left + right) / 2;
		while (mid >= left && mid <= right) {
			int midVal = a[mid];
			if (midVal == target) {
				return findFirst(a, target, mid);
			}
			if (midVal < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new P14().binarySearch(new int[]{1,4,4,5,7,7,8,9,9,10}, 1));
	}
}
