package classifier.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import util.resource.ResourceReader;

import analyze.one.Analyzer;

@SuppressWarnings("unused")
public class AnalyzerUtil {

	public static Analyzer analyzer = initAnalyzer();
	
	private static final String NEW_DICT_PAHT = "";
	
	public static Analyzer initAnalyzer() {
		Analyzer analyzer = new Analyzer();
		analyzer.initDictMap();
		
		ResourceReader reader = new ResourceReader("/classifier/goods/goods_dic.txt");
		try {
			reader.load();
			String line = null;
			while( (line = reader.readLine()) != null ) {
				analyzer.loadExternal(line);
			}
			
		} catch (Exception e) {
			
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return analyzer;
	}
	
	public static Map<String, Integer> getTermCount(String text, int top) {
		Map<String, Integer> analyzeResult = analyzer.analyzeCount(text, false);
		Map<String, Integer> finalResult = new HashMap<String, Integer>(top);
		
		List<Map.Entry<String, Integer>> terms = new ArrayList<Map.Entry<String,Integer>>(analyzeResult.entrySet());
		Collections.sort(terms, new Comparator<Map.Entry<String, Integer>>(){

			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				int one = o1.getValue(),
				two = o2.getValue();
				if(one > two) {
					return -1;
				} else if(one < two) {
					return 1;
				}
				return 0;
			}
		});
		
		for(Map.Entry<String, Integer> entry : terms) {
			finalResult.put(entry.getKey(), entry.getValue());
			if(finalResult.size() >= top) {
				break;
			}
		}
		return finalResult;
	}
	
	public static void main(String[] args) {
		String s = "****圆领肌理变化毛织开衫,开衫";
		Map<String, Integer> rs = AnalyzerUtil.getTermCount(s, 20);
		for(Map.Entry<String, Integer> en : rs.entrySet()) {
			System.out.println(en.getKey() + "\t\t" + en.getValue());
		}
	}
}
