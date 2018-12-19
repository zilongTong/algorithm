package sort.qtest.sort;

import java.util.Arrays;

import sort.qtest.ISort;

public class SystemSort implements ISort {

	public void sort(Integer[] array) {
		Arrays.sort(array);
	}

}
