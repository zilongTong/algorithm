package classifier.itf;

/**
 * 分类器概念
 * @author HQ01U8435
 *
 */
public interface Concept {

	/**
	 * 概念的名称，标识符
	 * @return
	 */
	public String getName();
	
	/**
	 * 概念的父级概念
	 * @return
	 */
	public Concept getParent();
	
	/**
	 * 获取训练后，该概念对应的实例集合
	 * @return
	 */
	public Instance[] getInstances();
}
