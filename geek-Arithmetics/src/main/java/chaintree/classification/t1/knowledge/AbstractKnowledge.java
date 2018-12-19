package chaintree.classification.t1.knowledge;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类器知识类
 * 属性有：知识、分类列表
 * @author HQ01U8435
 *
 */
public class AbstractKnowledge {
	/**
	 * 分类名称（分类列表）
	 */
	protected List<String> cateKeys = new ArrayList<String>(0);
	
	public List<String> getCateKeys() {
		return cateKeys;
	}
	public void setCateKeys(List<String> cateKeys) {
		this.cateKeys = cateKeys;
	}
	
}
