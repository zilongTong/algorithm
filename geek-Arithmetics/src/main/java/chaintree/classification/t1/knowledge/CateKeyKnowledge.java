package chaintree.classification.t1.knowledge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import chaintree.classification.Keyword;

public class CateKeyKnowledge extends AbstractKnowledge implements IKnowledge {
	/**
	 * 分词学到的知识
	 * 分类对应的关键字信息
	 * ｛
	 * 		分类标识 ： 
	 * 		｛
	 * 			关键字 ： 次数
	 * 		 ｝
	 * 	｝
	 */
	protected Map<String, Map<String, Integer>> knowledge = new HashMap<String, Map<String,Integer>>(32, 0.95f);

	public List<Keyword> getKeywords(Map<String, Integer> getInfos) {
		List<Keyword> keywords = new ArrayList<Keyword>();
		Iterator<String> keys = getInfos.keySet().iterator();
		while(keys.hasNext()) {
			//关键字
			String key = keys.next();
			//关键字在描述中出现的次数，出现次数越多，代表越重要
			Integer count = getInfos.get(key);

			Keyword kw = new Keyword(key, count);
			//遍历所有分类
			for(String cat : cateKeys) {
				//获得该分类中所有出现过的关键字的信息
				Map<String, Integer> catWordInfo = knowledge.get(cat);
				/*
				 * 如果该分类曾经出现过该关键字，则获得相应信息
				 */
				Integer wordCount = catWordInfo.get(key);
				if(wordCount != null) {
					kw.addCate(cat, wordCount);
				}
			}
			
			keywords.add(kw);
		}
		return keywords;
	}

	public void learn(String cate, Map<String, Integer> wordCountForCates) {
		if(knowledge.get(cate) == null) {
			knowledge.put(cate, wordCountForCates);
			cateKeys.add(cate);
		} else {
			Iterator<String> words = wordCountForCates.keySet().iterator();
			while (words.hasNext()) {
				String word = words.next();
				Integer thisCount = wordCountForCates.get(word);
				learn(cate, word, thisCount);
			}
		}
		
	}

	public void learn(String cate, String word, Integer wordCount) {
		Integer oldCount = knowledge.get(cate).get(word);
		if(oldCount == null) {
			knowledge.get(cate).put(word, wordCount);
		} else {
			knowledge.get(cate).put(word, oldCount + wordCount);
		}
	}

	public int cateSize() {
		return cateKeys.size();
	}
}
