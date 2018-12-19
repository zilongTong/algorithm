package sort.qtest.sort;

import java.util.Comparator;

import sort.merge.QuickSort;
import sort.qtest.ISort;

public class OldQuickSort implements ISort {

	public void sort(Integer[] array) {
		QuickSort<Integer> qs = new QuickSort<Integer>(array,  
                new Comparator<Integer>() {  
            public int compare(Integer o1, Integer o2) {  
                return o1 - o2;  
            }  
        }); 
		
		qs.sort();
	}

}
