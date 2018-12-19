package com.wj.lintcode.er_fen;
/*
 *  搜索二维矩阵

 描述
 笔记
 数据
 评测
写出一个高效的算法来搜索 m × n矩阵中的值。

这个矩阵具有以下特性：

每行中的整数从左到右是排序的。
每行的第一个数大于上一行的最后一个整数。
您在真实的面试中是否遇到过这个题？ Yes
样例
考虑下列矩阵：

[
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
给出 target = 3，返回 true
 */
public class P28 {
	//数据中是否存在target
	public boolean searchMatrix(int[] a, int target) {
		if (a == null || a.length == 0) {
			return false;
		}

		int right = a.length - 1;
		int left = 0;
		int mid = (left + right) / 2;
		while (mid >= left && mid <= right) {
			int midVal = a[mid];
			if (midVal == target) {
				return true;
			}
			if (midVal < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length <= 0 || matrix[0] == null) {
			return false;
		}
		if (matrix[0][0] > target) {
			return false;
		}
		int len = matrix.length;
		int nLen = matrix[0].length;
		if (matrix[len - 1][nLen - 1] < target) {
			return false;
		}
		int left = 0;
		int right = len - 1;
		int mid = (left + right) / 2;
		
		//二分法找到目标可能所在的数组
		//从目标数组查询目标
		while (mid >= left && mid <= right) {
			int[] midArr = matrix[mid];
			if (midArr[0] <= target && midArr[nLen - 1] >= target) {
				return searchMatrix(midArr, target);
			} else {
				int midArrFirst = midArr[0];
				if (midArrFirst > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
				mid = (left + right) / 2;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] arr = new int[3][];
		arr[0] = new int[] { 1, 3, 5, 7 };
		arr[1] = new int[] { 10, 11, 16, 20 };
		arr[2] = new int[] { 23, 30, 34, 50 };

		P28 p = new P28();
		System.out.println(p.searchMatrix(arr, 3));
		
		System.out.println(p.searchMatrix(new int[0][], 1));
	}
}
