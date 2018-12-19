package sort.merge;

import java.util.Comparator;

import sort.heap.Heap;

/**
 * 
 * @author wjyuian
 * 	topn指的是从已经存在的数组中，找出最大（或最小）的前n个元素。 
	topn算法实现思路（找最大的n个元素） 
	1：取出数组的前n个元素，创建长度为n的最小堆。 
	2：从n开始循环数组的剩余元素，如果元素(a)比最小堆的根节点大，将a设置成最小堆的根节点，并让堆保持最小堆的特性。 
	3：循环完成后，最小堆中的所有元素就是需要找的最大的n个元素。 
 *
 */
public class HeapApp {
	
	 public static int[] toPrimitive(Integer array[]) {  
	        if (array == null)  
	            return null;  
	        if (array.length == 0)  
	            return new int[0];  
	        int result[] = new int[array.length];  
	        for (int i = 0; i < array.length; i++)  
	            result[i] = array[i].intValue();  
	  
	        return result;  
	    }  
	  
	    /** 
	     * 1：取出数组的前n个元素，创建长度为n的最小堆。 
	     * 2：从n开始循环数组的剩余元素，如果元素(a)比最小堆的根节点大，将a设置成最小堆的根节点，并让堆保持最小堆的特性。 
	     * 3：循环完成后，最小堆中的所有元素就是需要找的最大的n个元素。 
	     *  
	     * @param array 
	     * @param n 
	     * @return 
	     */  
	    public static int[] topn(int[] array, int n) {  
	        if (n >= array.length) {  
	            return array;  
	        }  
	        Integer[] topn = new Integer[n];  
	        for (int i = 0; i < topn.length; i++) {  
	            topn[i] = array[i];  
	        }  
	  
	        Heap<Integer> heap = new Heap<Integer>(topn, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o1 - o2;
				}
	        	
			});
	        for (int i = n; i < array.length; i++) {  
	            int value = array[i];  
	            int min = heap.root();  
	            if (value > min) {  
	                heap.setRoot(value);  
	            }  
	        }  
	        return toPrimitive(topn);  
	    }  
	  
	    public static void main(String[] args) {  
	        int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 11, 9, 10, 100 };  
	        array = new int[] { 101, 2, 3, 4, 5, 6, 7, 8, 11, 9, 10, 100 };  
	        int[] result = topn(array, 5);  
	        for (int integer : result) {  
	            System.out.print(integer + ",");  
	        }  
	    }  
}
