package com.wj.lintcode.int_arr;

/*
 * 
 * 给出一个无序的正数数组，找出其中没有出现的最小正整数。

您在真实的面试中是否遇到过这个题？ Yes
样例
如果给出 [1,2,0], return 3
如果给出 [3,4,-1,1], return 2

 */
public class P189 {
	public int firstMissingPositive(int[] arr) {
		if(arr == null || arr.length < 1) {
			return 1;
		}
		int len = arr.length;
		//长度为len的数组，未出现的最小正整数的范围就是【1 - len + 1】
		int[] temp = new int[len];
		
		for(int i : arr) {
			//只考虑1到len的数值；充分利用数组空间，则下标从0开始
			if(i > 0 && i <= len) {
				//将其设置为1，表示该数出现过，注意下标的转换（-1和+1还原）
				temp[i - 1] = 1;
			}
		}
		
		//在范围内，最大的结果是len+1
		int min = len + 1;
		for(int i = 0; i < len; i ++) {
			int v = temp[i];
			if(v <= 0) {//表示未出现过的值
				if(i < min) {//找到最小的
					min = i + 1;//下标就是目标结果，进行加1
				}
			}
		}
		return min;
    }
	
	public static void main(String[] args) {
		P189 p = new P189();
		
		System.out.println(p.firstMissingPositive(new int[]{1}));
	}
}
