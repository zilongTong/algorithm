package com.wj.lintcode.int_arr;

/*
 * 给一个包含 n 个整数的数组 S, 找到和与给定整数 target 最接近的三元组，返回这三个数的和。

 注意事项

只需要返回三元组之和，无需返回三元组本身

您在真实的面试中是否遇到过这个题？ Yes
样例
例如 S = [-1, 2, 1, -4] and target = 1. 和最接近 1 的三元组是 -1 + 2 + 1 = 2.

 */
public class P59 {
	private int sumArray(int[] arr) {
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		return sum;
	}
	//target中储存的是元素的下标；规则是下标元素对应的距离，从大到小
	private void resort(int[] target, int[] distanceArray) {
		for(int i = 0, len = target.length; i < len; i ++) {
			int currentIndexDistance = distanceArray[target[i]];
			int currentDistanceIndex = i;
			for(int j = i + 1; j < len; j ++) {
				if(distanceArray[target[j]] > currentIndexDistance) {//找到一个比当前值大的
					currentIndexDistance = distanceArray[target[j]];
					currentDistanceIndex = j;
				}
			}
			if(currentDistanceIndex > i) {//交换
				int iValue = target[i];
				target[i] = target[currentDistanceIndex];
				target[currentDistanceIndex] = iValue;
			}
		}
	}
	
	private void resortIndexArrayAndCompareWith(int[] target, int[] distanceArray, int currentIndex) {
		if(currentIndex >= 0) {
			//交换
			int distance = distanceArray[currentIndex];
			if(distance < distanceArray[target[0]]) {
				target[0] = currentIndex;
				//替换之后再进行一次排序
				resort(target, distanceArray);
			}
		}
	}
	
	public int threeSumClosest(int[] numbers, int target) {
		if(numbers == null) {
			return 0;
		}
		int len = numbers.length;
		if(len <= 3) {
			return sumArray(numbers);
		}
//		System.out.println(LintUtils.intArrayToString(numbers));

		//记录距离，绝对值
		int[] distance = new int[len];
		for(int i = 0; i < len; i ++) {
			int v = numbers[i];
			v = Math.abs(target - v);
			distance[i] = v;
		}
//		System.out.println(LintUtils.intArrayToString(distance));
		
		//距离最近的三个下标；对应距离最大的元素的下标排在前面
		//numbers中下标为i的元素，i储存在bottom3IndexArray中，距离储存在distance中
		//按照bottom3IndexArray的定义；距离最大的下标储存在bottom3IndexArray[0]，对应距离是distance[bottom3IndexArray[0]]
		int[] bottom3IndexArray = new int[3];
		
		int count = 0;
		for(int i = 0; i < len; i ++) {
			if(count < 3) {//不足三个
				bottom3IndexArray[count] = i;
				count ++;
			} else {
				//先进行一次排序
				resort(bottom3IndexArray, distance);
				resortIndexArrayAndCompareWith(bottom3IndexArray, distance, i);
			}
		}
		
		int sum = 0;
		for(int index : bottom3IndexArray) {
			sum += numbers[index];
		}
		
		return sum;
    }
	
	public static void main(String[] args) {
		
		System.out.println(new P59().threeSumClosest(new int[]{-2,-3,-4,-5,-100,99,1,4,4,4,5,1,0,-1,2,3,4,5}, 77));
	}
}
