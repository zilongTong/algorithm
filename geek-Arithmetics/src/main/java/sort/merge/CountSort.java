package sort.merge;

import java.lang.reflect.Array;

public class CountSort<T extends Number> {

	private T[] array;
	
	public CountSort(T[] array) {
		this.array = array;
	}
	
	public void sort() {
		int[] count = new int[array.length + 1];
		for(T i : array){
			int iv = i.intValue();
			count[iv] ++;
		}
		for (int i = 1; i < count.length; i++) {  
            count[i] += count[i - 1];  
        }  
		
        @SuppressWarnings("unchecked")  
        T[] copy = (T[]) Array.newInstance(Number.class, array.length);  
        for (int i = copy.length - 1; i > -1; i--) {  
            int value = array[i].intValue();  
            copy[count[value] - 1] = array[i];  
            count[value]--;  
        }  
        this.array = copy;
	}
	
	public static void main(String[] args) {  
        Integer[] temp = new Integer[] { 9, 8, 7, 4, 3, 5, 6, 1 };  
        // temp = new Integer[] { 9, 8, 7, 6, 5,4, 3, 2 };  
        temp = new Integer[] { 2, 5, 3, 0, 2, 3, 0, 3 };  
        temp = new Integer[] {  9, 8, 7, 4, 3, 5, 6, 1,0  };  
        CountSort<Integer> qs = new CountSort<Integer>(temp);  
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
