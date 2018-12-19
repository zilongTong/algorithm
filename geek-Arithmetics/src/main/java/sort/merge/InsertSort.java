package sort.merge;

import java.util.Arrays;
import java.util.Comparator;
import sort.util.AbstractSort;
import sort.util.Sort;

/**
 * 
 * @author wjyuian
 *	插入排序好比抓牌，一副牌是待排序的数组，拿一张牌，跟手里的牌从右到左一张张比较，插入到合适的位置。 
	优点：适应小数据量排序，空间消耗小。 
	缺点：当数据量比较大时，排序效率不高。 

	代码结构： 
	Sort:排序接口 
	AbstractSort：排序抽象类 
	InsertSort:排序算法。
 * @param <T>
 */
public class InsertSort<T> extends AbstractSort<T> {
	
	public InsertSort(T[] array, Comparator<? super T> comp) {
		init(array, comp);
	}
	
	public T[] sort(T... array) {
		if(array.length < 1){
			if(this.array == null || this.array.length < 1){
				return null;
			}
			return sort(this.array);
		}
		for (int i = 1; i < array.length; i++) {  
            T current = array[i];  
            int j = i - 1;  
            /* 
             * 如果array[j]前一个元素大于current,将array[j]移到下一个位置 
             */  
            for (; j > -1 && comp.compare(current, array[j]) < 0; j--) {  
                array[j + 1] = array[j];  
            }  
            //将current设置到j+1位置  
            array[j + 1] = current;  
        }  
        return array;  
	}

	public static void main(String[] args) {
		Integer[] temp = null;  
        temp = new Integer[] { 16, 14, 8, 7, 9, 3, 2, 4, 1 };  
  
        Comparator<Integer> comp = new Comparator<Integer>() {  
            public int compare(Integer o1, Integer o2) {  
                return o1 - o2;  
            }  
        };  
        Sort<Integer> sort = new InsertSort<Integer>(temp, comp);  
        Integer[] clone = temp.clone();  
        Arrays.sort(clone);  
        boolean equals = Arrays.equals(clone, sort.sort());  
        assert equals;  
        System.out.println(equals);
        System.out.println(Arrays.toString(temp));  
	}
}
