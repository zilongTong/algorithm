package sort.util;

public interface Sort<T> {

	/**
	 * 返回排序后的数组
	 * @param array
	 * @return
	 */
	public T[] sort(T... array);
}
