package chaintree.classification.t1.knowledge;

import java.util.List;
import java.util.Map;

import chaintree.classification.Keyword;

/**
 * 分类器知识接口
 * 提供知识学习接口，
 * 获取学到的分类数接口
 * @author HQ01U8435
 *
 */
public interface IKnowledge {

	/**
	 * 分类器学习知识
	 * @param cate	分类
	 * @param wordCountForCates	与该分类对应的关键字和数量
	 * 							即，该分类出现了哪些关键字以及出现的数量，进一步说就是某一关键字出现，属于该分类的概率
	 */
	public void learn(String cate, Map<String, Integer> wordCountForCates);
	/**
	 * 分类器学习单个关键字的信息
	 * @param cate
	 * @param word
	 * @param wordCount
	 */
	public void learn(String cate, String word, Integer wordCount);
	
	/**
	 * 根据关键字次数和历史知识，计算关键字信息
	 * @param getInfos
	 * @return
	 */
	public List<Keyword> getKeywords(Map<String, Integer> getInfos);
	
	/**
	 * 分类数量
	 * @return
	 */
	public int cateSize();
}
