package sort.qtest.sort;

import sort.qtest.ISort;

public class Sort1 implements ISort {

	public void sort1(Integer[] array, int p, int r) {
		if(p >= r) {
			return;
		}
		int x = array[p];
		int j = p;
		for(int i = p + 1; i <= r; i ++) {
			if(array[i] < x) {
				swap(array, ++ j, i);
			}
		}
		swap(array, p, j);
		sort1(array, p, j - 1);
		sort1(array, j + 1, r);
		
	}
	
	public void swap(Integer[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void sort(Integer[] array) {
		sort1(array, 0, array.length - 1);
		
	}
	
	
}
