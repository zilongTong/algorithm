package com.wj.lintcode.util;

public class LintUtils {

	public static String intArrayToString(int[] arr) {
		StringBuilder b = new StringBuilder();
		for(int i = 0, len = arr.length; i < len; i ++) {
			b.append("(" + i + ")").append(arr[i]).append(", ");
		}
		int len = b.length();
		if(len > 1) {
			b.delete(len - 2, len);
		}
		return "[" + b.toString() + "]";
	}
	
	public static String intArrayIndexToString(int[] arr) {
		
		StringBuilder b = new StringBuilder();
		for(int i = 0, len = arr.length; i < len; i ++) {
			b.append(i).append(", ");
		}
		int len = b.length();
		if(len > 1) {
			b.delete(len - 2, len);
		}
		return "[" + b.toString() + "]";
	}
}
