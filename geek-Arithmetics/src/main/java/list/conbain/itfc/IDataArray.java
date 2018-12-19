package list.conbain.itfc;
/**
 *
 * @author Smile.Wu
 * @version 2015-7-17
 */
public interface IDataArray {
	
	/**
	 * 空数据
	 */
	public static final Long NO_MORE_DATA = Long.MAX_VALUE;
	
	/**
	 * 计算下一个符合条件的文档，即数值型主键
	 * @return
	 */
	public long nextDoc();

	/**
	 * 当前已计算好的数值
	 * @return
	 */
	public long dataID();
	
	/**
	 * 数值跳跃，跳跃到大于等于指定数值（dataID）的数值，并返回
	 * @param dataID 指定数值
	 * @return
	 */
	public long advance(long dataID);
}
