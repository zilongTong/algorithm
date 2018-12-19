package com.wj.lintcode.er_fen;

/*
 *  寻找旋转排序数组中的最小值

假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。

你需要找到其中最小的元素。

你可以假设数组中不存在重复的元素。
 */
public class P159 {

	private boolean sorted(int[] nums, int first, int last) {
		if(nums[last] > nums[first]) {
			return true;
		}
		return false;
	}
	private int getMin(int[] nums, int from, int to) {
		int index = from + 1;
		int first = nums[from];
		while(index <= to) {
			if(nums[index] < first) {
				return nums[index];
			}
			index ++;
		}
		return 0;
	}
	public int findMin(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		if(nums[right] > nums[left]) {
			return nums[left];
		}
		int mid = (left + right) / 2;
		while(mid >= left && mid <= right) {
			if(right - left <= 2) {
				return getMin(nums, left, right);
			}
			if(sorted(nums, left, mid)) {
				//左边是有序，则最小在右边
				left = mid;
			} else {
				//否则最小在左边
				right = mid;
			}
			mid = (left + right) / 2;
		}

		return 0;
	}

	public static void main(String[] args) {
//		System.out.println(new P159().findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(new P159().findMin(new int[] { 266,267,268,269,271,278,282,292,293,298,6,9,15,19,21,26,33,35,37,38,39,46,49,54,65,71,74,77,79,82,83,88,92,93,94,97,104,108,114,115,117,122,123,127,128,129,134,137,141,142,144,147,150,154,160,163,166,169,172,173,177,180,183,184,188,198,203,208,210,214,218,220,223,224,233,236,241,243,253,256,257,262,263 }));
	}
}
