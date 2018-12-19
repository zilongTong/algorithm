package analyze.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SameWordFilter {

	private List<String> _words = new ArrayList<String>(0);
	private Comparator<Integer> _comparator = new IntegerSort();
	private Map<String, String> _resultFilter = new HashMap<String, String>(5, 0.95f);
	
	public SameWordFilter(List<String> words) {
		_words = words;
	}
	public void addWords(String word) {
		_words.add(word);
	}

	public String code(String s) {
		String rs = "";
		List<Integer> codes = new ArrayList<Integer>();
		for(int i = 0, len = s.length(); i < len; i ++) {
			int cv = s.codePointAt(i);
			if(cv == 32) {
				continue;
			}
			codes.add(cv);
		}
		Collections.sort(codes, _comparator);
		for(Integer code : codes) {
			rs += String.valueOf(code) + "_";
		}
		return rs;
	}
	
	public List<String> filter() {
		List<String> rs = new ArrayList<String>(0);
		
		for(String word : _words) {
			String code = code(word);
			String prevWord = _resultFilter.get(code);
			if(prevWord == null) {
				_resultFilter.put(code, word);
				rs.add(word);
			}
		}
		
		return rs;
	}
	
	
	class IntegerSort implements Comparator<Integer> {
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
	}
}
