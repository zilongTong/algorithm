package classifier.itf;

/**
 * 概念对应的属性
 * @author HQ01U8435
 *
 */
public interface Attribute {

	/**
	 * 获取属性的标识名称
	 * @return
	 */
	public String getName();
	
	/**
	 * 属性对应的值
	 * @return
	 */
	public Object getValue();
}
