package sort.util;

import java.util.Arrays;
import java.util.Comparator;

public abstract class AbstractSort<T> implements Sort<T> {
	/**
	 * 待排数组
	 */
	protected T[] array;

	/**
	 * 用于比较数组大小
	 */
	protected Comparator<? super T> comp;
	
	public void init(Comparator<? super T> comp) {
		this.comp = comp;
	}
	
	public void init(T[] array, Comparator<? super T> comp) {
		this.array = array;
		this.comp = comp;
	}
	
	public void print(T[] array) {
		System.out.println(Arrays.toString(array));
	}
	
	/**
	 * 交换数组中两个位置的元素
	 * @param array 数组
	 * @param i 下标i
	 * @param j 下标j
	 */
	public void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
