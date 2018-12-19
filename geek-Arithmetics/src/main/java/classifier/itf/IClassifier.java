package classifier.itf;

/**
 * 分类训练器
 * @author HQ01U8435
 *
 */
public interface IClassifier {

	/**
	 * 分类器标识符（名称）
	 * @return
	 */
	public String getName();
	
	/**
	 * 分类器训练
	 * @return
	 */
	public boolean train();
	
	/**
	 * 分析某个新的实例，将它归到某个概念中
	 * @param instance 某个待分类的实例
	 * @return
	 */
	public Concept classify(Instance instance);
}
