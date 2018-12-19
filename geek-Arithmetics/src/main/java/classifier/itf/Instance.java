package classifier.itf;

/**
 * 分类器实例
 * @author HQ01U8435
 *
 */
public interface Instance {

	/**
	 * 某个实例具有的属性
	 * @return
	 */
	public Attribute[] getAttributes();
	
	/**
	 * 实例所属的概念
	 * @return
	 */
	public Concept getConcept();
	
	/**
	 * 根据属性的名称，获取实例对应属性信息
	 * @param attrName 属性名称
	 * @return
	 */
	public Attribute getAttributeByName(String attrName);
	
	/**
	 * 显示一些细节信息
	 */
	public void print();
}
