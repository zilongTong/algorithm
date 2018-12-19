package com.wj.lintcode.int_arr;

import com.wj.lintcode.util.LintUtils;

public class P64 {
	
	//把arr数组中的，从from开始到to的位置的所有数，往后移动step位置
	//from和to都包含
	private void moveAdvance(int[] arr, int from, int to, int step) {
		for(int index = to; index >= from; index --) {
			arr[index + step] = arr[index];
		}
	}
	
	//在arr中，从from开始，寻找比value小的数的个数
	//包含from的位置
	private int minThanValueInArrayFrom(int value, int[]arr, int from) {
		int count = 0;
		for(int i = from, len = arr.length; i < len; i ++) {
			if(arr[i] < value) {
				count ++;
			}
		}
		return count;
	}
	//把fromArr中，从fromIndex到toIndex位置的数据，copy到dist数组中，从starIndex位置开始
	//toIndex为exclude
	private void fill(int[] fromArr, int fromIndex, int toIndex, int[] dist, int startIndex) {
		for(int i = fromIndex; i < toIndex; i ++) {
			dist[startIndex] = fromArr[i];
			startIndex ++;
		}
	}
	
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {

		int aindex = 0;
		int bindex = 0;
		int across = m;
		int alen = A.length;
		int blen = B.length;
		
		while(aindex < alen && bindex < blen) {
			int va = A[aindex];
			
			int minCount = minThanValueInArrayFrom(va, B, bindex);
			if(minCount > 0) {
				moveAdvance(A, aindex, across - 1, minCount);
				fill(B, bindex, bindex + minCount, A, aindex);
				
				//a跳跃到下一个检测的位置
				aindex += minCount + 1;
				//b跳跃到下一个未检测的地方
				bindex += minCount;
				//across后移
				across += minCount;
			} else {
				if(aindex >= across) {
					fill(B, bindex, blen, A, aindex);
					break;
				} else {
					aindex ++;
				}
			}
		}
    }
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,0,0};
		int[] b = new int[]{4,5};
		
		new P64().mergeSortedArray(a, 3, b, 2);
		System.out.println(LintUtils.intArrayToString(a));
	}
}
