package sort.qtest;

import java.util.Random;

import sort.qtest.sort.OldMergeSort;
import sort.qtest.sort.OldQuickSort;
import sort.qtest.sort.Sort1;
import sort.qtest.sort.Sort2;
import sort.qtest.sort.SystemSort;
//http://rdc.taobao.com/team/jm/archives/252
public class SortData {

	public static Integer[] LARGE_DATA = initIntArray();
	
	public static void init() {
		LARGE_DATA = initIntArray();
	}
	
	public static Integer[] initIntArray() {
		int max = 1000000;
		Integer[] is = new Integer[max];
		for(int i = 0; i < max; i ++) {
			int r = new Random(System.currentTimeMillis() + i).nextInt(max);
			is[i] = r;
		}
		return is;
	}
	
	public static void print(Integer[] array, int n) {
		int c = 0;
		for(Integer i : array) {
			System.out.print(i+"\t");
			c ++;
			if(c >= n) {
				break;
			}
		}
		System.out.println();
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Integer[] a1 = new Integer[]{5,2,8,7,1,22,66,33};
		SortCostTest.testSort(new Sort1());
		SortCostTest.testSort(new Sort2());
		SortCostTest.testSort(new SystemSort());
		SortCostTest.testSort(new OldQuickSort());
		SortCostTest.testSort(new OldMergeSort());
		
	
	}
}
