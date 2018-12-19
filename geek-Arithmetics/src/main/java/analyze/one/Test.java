package analyze.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	
	public static List<String> initDicts() {
		List<String> dicts = new ArrayList<String>(0);
		String[] s = new String[]{"中国","中央","中心","中国人","中华","银行","中央人民银行","中间","中间人","中华人民共和国","国人","国际","国庆"};
		dicts.addAll(Arrays.asList(s));
		return dicts;
	}

	public static String getSrc(String f) throws IOException {
		InputStream is = null;
        InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder("");
		try {
			is = Analyzer.class.getResourceAsStream("/analyze/one/"+f+".txt");
	        isr = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(isr, 512);
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if(br != null) {
				br.close();
			}
			if(isr != null) {
				isr.close();
			}
			if(is != null) {
				is.close();
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		Analyzer analyzer = new Analyzer();
		analyzer.initDictMap();
		analyzer.loadExternal("java");
		String t = "";
//		t = "中华人民";
		t = getSrc("jianli1");
		long b = System.currentTimeMillis();
		int topN = 500;
		List<WordCounter> counters = analyzer.process(new WordCounterData(topN), t, false);
		long cost = System.currentTimeMillis() - b;
		if(counters != null) {
			for(WordCounter c : counters) {
				System.out.println(c);
			}
		}

		System.out.println("待分析文本长度：" + t.length());
		System.out.println("根据分词统计，次数最多的前 " + topN + "名结果如下上，耗时：" + cost + " 毫秒");
		
	}
}
