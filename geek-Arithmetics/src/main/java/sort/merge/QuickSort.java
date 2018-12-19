package sort.merge;

import java.util.Comparator;

/**
 * @author wjyuian
 * 	快速排序算法的思想来自于分治法（我的理解就是大事化小，小事化了）。 
	优点：速度快，内存占用小。 
	缺点：对于有序数组，耗时比较长（稳定性不够好） 
	实现步骤： 
	1：找出数组的最后位置的值（mid），不大于mid的，排在数组的前面，mid排在中间，比mid大的排在mid的后面（对应partition方法，返回mid的索引位置）。 
	2：将mid的前半部分做为子数组，递归调用步骤1；将mid的后半部分做为子数组，递归调用步骤1 
 *
 */
public class QuickSort<T> {
	private T[] array;  
	  
    private Comparator<? super T> comp;  
  
    public QuickSort(T[] array, Comparator<? super T> comp) {  
        this.array = array;  
        this.comp = comp;  
    }  
  
    public void sort() {  
        quicksort(0, array.length - 1);  
    }  
  
    private void quicksort(int p, int r) {  
        if (p < r) {  
            int q = partition(p, r);  
            quicksort(p, q - 1);  
            quicksort(q + 1, r);  
        }  
    }  
  
    public int partition(int p, int r) {  
        T x = array[r];  
        int less = p - 1;  
        for (int i = p; i < r; i++) {  
            if (comp.compare(array[i], x) <= 0) {  
                less++;  
                swap(less, i);  
            }  
        }  
        less++;  
        swap(less, r);  
        
        return less;  
    }  
  
    public void swap(int i, int j) {  
        T tem = array[i];  
        array[i] = array[j];  
        array[j] = tem;  
    }  
  
    public static void main(String[] args) {  
        Integer[] temp = new Integer[] { 3, 5, 9, 8, 12, 1, 55, 70};  
//        QuickSort<Integer> qs = new QuickSort<Integer>(temp,  
//                new Comparator<Integer>() {  
//                    public int compare(Integer o1, Integer o2) {  
//                        return o1 - o2;  
//                    }  
//                });  
//        qs.sort();  
//        qs.print();  
    	En[] temp1 = new En[8];
    	for(int i = 0; i < temp.length; i ++) {
    		temp1[i] = new En(temp[i]);
    	}
    	
    	QuickSort<En> qs = new QuickSort<En>(temp1, new Comparator<En>() {
			public int compare(En o1, En o2) {
				return o1.getC() - o2.getC();
			}
		});
    	qs.sort();
    	qs.print();
    }  
  
    private void print() {  
        for (T i : array) {  
            System.out.print(i + " ");  
        }  
        System.out.println();  
    }  
}
