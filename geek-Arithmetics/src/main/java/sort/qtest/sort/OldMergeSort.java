package sort.qtest.sort;

import java.util.Comparator;

import sort.merge.MergeSort;
import sort.qtest.ISort;

public class OldMergeSort implements ISort {

	public void sort(Integer[] array) {
		MergeSort<Integer> ms = new MergeSort<Integer>(  
                new Comparator<Integer>() {  
            public int compare(Integer o1, Integer o2) {  
                return o1 - o2;  
            }  
        }); 
		
		ms.sort(array);
	}

}
