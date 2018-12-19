package sort.qtest.sort;

import sort.merge.CountSort;
import sort.qtest.ISort;

public class OldCountSort implements ISort {

	public void sort(Integer[] array) {
		CountSort<Integer> cs = new CountSort<Integer>(array);
		cs.sort();
	}

}
