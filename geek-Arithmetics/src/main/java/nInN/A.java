package nInN;

import java.util.Stack;

public class A {

	static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {
		long b = System.currentTimeMillis();
		show(Test.total, Test.createArray(50));
		
		System.out.println("cost : " + (System.currentTimeMillis() - b));
	}

	public static void show(int sum, Integer... nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == sum) {
				System.out.println(nums[i]);
				continue;
			}
			if (nums[i] > sum) {
				continue;
			}
			if (nums[i] < sum) {
				stack.clear();
				stack.push(nums[i]);
				cao(i, sum - nums[i], nums);
			}
		}
	}

	static void cao(int idx, int last, Integer[] nums) {
		for (int i = idx + 1; i < nums.length; i++) {
			if (nums[i] > last) {
				continue;
			}
			if (nums[i] == last) {
				stack.push(nums[i]);
				System.out.println(stack);
				stack.pop();
			} else if (nums[i] < last) {
				stack.push(nums[i]);
				cao(i, last - nums[i], nums);
				stack.pop();
			}
		}
	}

}
