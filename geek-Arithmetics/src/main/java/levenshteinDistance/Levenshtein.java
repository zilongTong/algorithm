package levenshteinDistance;

import java.util.Arrays;

/** 

 */
public class Levenshtein {

	public static int distance(String s, String t) {
		int n = 0, m = 0;
		if(s != null) {
			n = s.length();
		}
		if(t != null) {
			m = t.length();
		}
		if(n * m == 0) {
			return Math.max(n, m);
		}
		s = s.toLowerCase();
		t = t.toLowerCase();
		int[] v0 = new int[m + 1], v1 = new int[m + 1];
		for(int i = 0; i <= m; i ++) {
			v0[i] = i;
		}
		
		for(int i = 1; i <= n; i ++) {
			if(i > 1) {
				v0 = Arrays.copyOf(v1, v1.length);
			}
			v1[0] = i;
			
			for(int j = 1; j <= m; j ++) {
				int cost = s.charAt(i-1) == t.charAt(j-1) ? 0 : 1;
				
				int one = v1[j - 1] + 1;
				int two = v0[j] + 1;
				int three = v0[j - 1] + cost;
				
				int min = Math.min(Math.min(one, two), three);
				v1[j] = min;
			}
		}
		
		return v1[m];
	}
	
	public static void out(int[] t, int[] m) {
		for(int i = 0; i < t.length; i ++) {
			System.out.println(t[i]+" "+m[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String t = "人力资源经理/主管";
		String m = "人力资源经理/主管";
		String t1 = "人力资源经理/主管";
		System.out.println(distance(t, m));
		System.out.println(distance(t, t1));
		
	}
}
