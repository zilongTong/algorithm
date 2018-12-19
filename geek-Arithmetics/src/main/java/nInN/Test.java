package nInN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2013-1-8 下午3:20:05 
 */
public class Test {
	
	public static void t(List<Node> nodes, int a) {
		for(Node node : nodes) {
			t1(node, a);
		}
	}
	
	public static void t1(Node node, int a) {
		if(node.isEnd()) {
			return;
		}
		int preTotal = node.getSum();
		int newSum = preTotal + a;
		if(newSum <= total) {
			if(node.getNext().size() > 0) {
				for(Node n : node.getNext().values()) {
					t1(n, a);
				}
			}
			
			Node newNode = new Node(a, newSum == total ? true : false, newSum);
			if(!node.getNext().containsKey(a)) {
				node.getNext().put(a, newNode);
			}
		}
	}

	public static Set<String> ts = new HashSet<String>();
	public static void show(Node n, List<Integer> prev) {
		prev.add(n.getNum());
		if(n.getNext().size() > 0) {
			for(Node n1 : n.getNext().values()) {
				List<Integer> nl = new ArrayList<Integer>();
				nl.addAll(prev);
				show(n1, nl);
			}
		} else if(n.isEnd()) {
			System.out.println(prev);
			String t = prev.toString();
			ts.add(t);
			prev.clear();
			c ++;
		}

	}

	public static Integer[] createArray(int n) {
		Integer[] arr = new Integer[n];
		Random r = new Random(System.currentTimeMillis());
		for(int i = 0; i < n; i ++) {
			arr[i] = r.nextInt(total + 10);
		}

//		arr = new Integer[]{4, 3, 2, 2, 1, 1};
		arr = new Integer[]{1,2,16,3,17,4,6,7,8,9,10,11,12,13,14,15,18,5};
//		arr = new Integer[]{3, 2, 7, 9, 8, 4, 5, 2, 4, 5, 7, 1, 3, 5, 6, 10, 4, 3, 9, 4, 6, 5, 9, 3, 4, 10, 1, 9, 7, 6, 9, 7, 1, 3, 10, 3, 4, 3, 2, 8, 7, 5, 4, 2, 3, 4, 6, 3, 7, 2};
		return arr;
	}
	public static int c = 0;
	public static int total = 20;
	public static void main(String[] args) {
		Integer[] arr = createArray(100);

//		Arrays.sort(arr);
		long b = System.currentTimeMillis();
		List<Node> nodes = new ArrayList<Node>();
		Set<Integer> deal = new HashSet<Integer>();
		for(Integer a : arr) {
			t(nodes, a);
//			if(deal.contains(a) || (a > total / 2 && a != total)) {
			if(deal.contains(a) || a > total) {
				continue;
			}
			Node n = new Node(a, a == total ? true : false, a);
			deal.add(a);
			nodes.add(n);
		}
		long t = System.currentTimeMillis() - b;
		System.out.println("src : " + Arrays.toString(arr));
		for(Node n : nodes) {
			show(n, new ArrayList<Integer>());
		}
		System.out.println("sum : " + total);
		System.out.println("array length : " + arr.length);
		System.out.println("cost : " + t);
		System.out.println("solutions : " + c);
		System.out.println(ts.size());
	}
}
