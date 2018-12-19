package analyze.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import analyze.one.topn.TopNCreator;

public class WordCounterData implements IData<List<WordCounter>> {
	
	private Map<String, WordCounter> map = new HashMap<>();
	
	private int topNum = 20;
	public WordCounterData() {
		
	}
	public WordCounterData(int n) {
		this.topNum = n;
	}
	
	@Override
	public void process(String data) {
		if(data != null && data.trim().length() > 1) {
			WordCounter wc = map.get(data);
			if(wc != null) {
				wc.addCount(1);
			} else {
				map.put(data, new WordCounter(data, 1));
			}
		}
	}

	@Override
	public List<WordCounter> value() {
		TopNCreator topNCreator = new TopNCreator(topNum);

		if(map != null && map.size() > 0) {
			for(WordCounter wc : map.values()) {
				topNCreator.insert(wc);
			}
		}
		
		List<WordCounter> list = new ArrayList<>();
		for(int i = 0, len = topNCreator.getSize(); i < len; i ++) {
			list.add((WordCounter) topNCreator.pop());
		}
		return list;
	}

}
