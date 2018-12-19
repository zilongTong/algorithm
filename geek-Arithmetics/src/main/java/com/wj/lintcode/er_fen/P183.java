package com.wj.lintcode.er_fen;
/*
 *  木材加工

有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。当然，我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度。

 注意事项

木头长度的单位是厘米。原木的长度都是正整数，我们要求切割得到的小段木头的长度也要求是整数。无法切出要求至少 k 段的,则返回 0 即可。

您在真实的面试中是否遇到过这个题？ Yes
样例
有3根木头[232, 124, 456], k=7, 最大长度为114.
 */
public class P183 {
	int count(int[] arr, int len) {
		int count = 0;
		for(int i = 0, size = arr.length; i < size; i ++) {
			count += arr[i] / len;
		}
		return count;
	}
	public int woodCut(int[] arr, int k) {
		if(arr == null || arr.length <= 0) {
			return 0;
		}
		//防止溢出
		long totalLen = 0;
		int arrSize = arr.length;
		for(int i = 0; i < arrSize; i ++) {
			totalLen += arr[i];
		}
		if(totalLen < k) {
			return 0;
		}
		
		int left = 1;
		int right = (int) (totalLen / k);
		int mid = (left + right) / 2;
		int maxLen = 1;
		while(mid >= left && mid <= right) {
			if(left == right) {
				break;
			}
			if(right - left == 1) {//死循环条件
				break;
			}
			int countMid = count(arr, mid);
			if(countMid >= k) {
				maxLen = mid;
				left = mid;
			} else {
				right = mid;
			}
			//防止溢出
			mid = (int) (((long)left + right) / 2);
		}
		
		return maxLen;
    }
	
	public static void main(String[] args) {
		System.out.println(new P183().woodCut(new int[]{2147483644,2147483645,2147483646,2147483647}, 4));
	}
}
