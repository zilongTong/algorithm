package chaintree.classification.t1.knowledge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import chaintree.classification.Keyword;

public class KeyCateKnowledge extends AbstractKnowledge implements IKnowledge {
	/**
	 * 分词学到的知识
	 * 分类对应的关键字信息
	 * ｛
	 * 		关键字 ： 
	 * 		｛
	 * 			分类标识 ： 次数
	 * 		 ｝
	 * 	｝
	 */
	protected Map<String, Map<String, Integer>> knowledge = new HashMap<String, Map<String,Integer>>(32, 0.95f);

	public List<Keyword> getKeywords(Map<String, Integer> getInfos) {List<Keyword> keywords = new ArrayList<Keyword>();
	Iterator<String> keys = getInfos.keySet().iterator();
	while(keys.hasNext()) {
		//关键字
		String key = keys.next();
		//关键字在描述中出现的次数，出现次数越多，代表越重要
		Integer count = getInfos.get(key);

		Keyword kw = new Keyword(key, count);

		Map<String, Integer> cksMap = knowledge.get(key);
		if(cksMap == null) {
			continue;
		} else {
			Iterator<String> cks = cksMap.keySet().iterator();
			while(cks.hasNext()) {
				String cate = cks.next();
				Integer oldCount = cksMap.get(cate);
				kw.addCate(cate, oldCount);
			}
		}
		keywords.add(kw);
	}
	return keywords;
	}

	public void learn(String cate, Map<String, Integer> wordCountForCates) {
		Iterator<String> words = wordCountForCates.keySet().iterator();
		while (words.hasNext()) {
			String word = words.next();
			Integer thisCount = wordCountForCates.get(word);
			learn(cate, word, thisCount);
		}
	}

	public void learn(String cate, String word, Integer wordCount) {
		if(knowledge.get(word) == null) {
			Map<String, Integer> cn = new HashMap<String, Integer>();
			cn.put(cate, wordCount);
			knowledge.put(word, cn);
			addCate(cate);
		} else {
			Integer count = knowledge.get(word).get(cate);
			if(count == null) {
				knowledge.get(word).put(cate, wordCount);
				addCate(cate);
			} else {
				knowledge.get(word).put(cate, wordCount + count);
			}
		}
	}

	public int cateSize() {
		return cateKeys.size();
	}
	
	private void addCate(String cname) {
		if(!cateKeys.contains(cname)) {
			cateKeys.add(cname);
		}
	}
}
