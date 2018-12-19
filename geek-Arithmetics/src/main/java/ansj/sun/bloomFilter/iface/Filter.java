package ansj.sun.bloomFilter.iface;

public interface Filter {

	/**
	 * @param str
	 * @return 判断一个字符串是否bitMap中存在
	 */
	public boolean contains(String str);

	/**
	 * @param str 在boolean的bitMap中增加一个字符串
	 */
	public void add(String str);
	
	/**
	 * @param str 需要增加并且查询的方法
	 * @return 如果存在就返回true .如果不存在.先增加这个字符串.再返回false
	 */
	public boolean containsAndAdd(String str) ;
	
	/**
	 * @param chars 传入char数组
	 * @return 
	 */
	public long myHashCode(String str) ;

}
