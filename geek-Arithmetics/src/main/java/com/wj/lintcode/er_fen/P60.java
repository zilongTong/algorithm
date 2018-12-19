package com.wj.lintcode.er_fen;
/*
 *  搜索插入位置

 描述
 笔记
 数据
 评测
给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。

你可以假设在数组中无重复元素。

您在真实的面试中是否遇到过这个题？ Yes
样例
[1,3,5,6]，5 → 2

[1,3,5,6]，2 → 1

[1,3,5,6]， 7 → 4

[1,3,5,6]，0 → 0

标签 
 */
public class P60 {
    public int searchInsert(int[] a, int target) {
    	if(a == null || a.length == 0) {
    		return 0;
    	}
    	
    	int right = a.length - 1;
    	int left = 0;
    	int mid = (left + right) / 2;
    	int index = 0;
    	while(mid >= left && mid <= right) {
    		int midVal = a[mid];
    		if(midVal == target) {
    			return mid;
    		}
    		if(midVal < target) {
    			left = mid + 1;
    			//目标可能在右边，如果没有相等的，则是当前下标 之后
    			index = mid + 1;
    		} else {
    			right = mid - 1;
    			//目标可能在左边，如果没有相等的，则是当前下标
    			index = mid;
    		}
			mid = (left + right) / 2;
    	}
    	if(index == a.length - 1) {
    		return index + 1;
    	}
    	//处理插在第一个位置
    	return index < 0 ? 0 : index;
    }
    
    public static void main(String[] args) {
		P60 p = new P60();
		System.out.println(p.searchInsert(new int[]{1,3,5,6}, 5));
		System.out.println(p.searchInsert(new int[]{1,3,5,6}, 2));
		System.out.println(p.searchInsert(new int[]{1,3,5,6}, 7));
		System.out.println(p.searchInsert(new int[]{1,3,5,6}, 0));
	}
}
