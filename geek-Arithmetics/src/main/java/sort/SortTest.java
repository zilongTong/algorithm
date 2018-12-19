package sort;

import java.util.Random;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-8-28 下午4:07:19 
 */
public class SortTest {
	public static int[] getRandomArray(int size) {
		int[] arr = new int[size];
		
		for(int i = 0 ; i < size; i++) {
			Random r = new Random(System.currentTimeMillis());
			int value = r.nextInt(size);
			arr[i] = value;
		}
		
		return arr;
	}
	
	public static int[] getSortedArray(int size) {
		int[] arr = new int[size];
		for(int i = 0 ; i < size; i++) {
			arr[i] = i;
		}
		
		return arr;
	}
	
	public static void testArray(int[] arr) {
		int size = arr.length;
		long total = 0;
		for(int i = 0; i < size; i ++) {
			if(arr[i] > 12800) {
				total += arr[i];
			}
		}
		System.out.println(total);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 1000000;
		int[] randomArray = getRandomArray(size);
		int[] sortedArray = getSortedArray(size);

		long b = System.currentTimeMillis();
		testArray(randomArray);
		System.out.println("randomArray : " + (System.currentTimeMillis() - b));
		
		b = System.currentTimeMillis();
		testArray(sortedArray);
		System.out.println("sortedArray : " + (System.currentTimeMillis() - b));

	}

}
