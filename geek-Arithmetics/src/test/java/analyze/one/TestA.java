package analyze.one;

import java.util.List;

public class TestA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Analyzer analyzer = new Analyzer();
		analyzer.initDictMap();
		analyzer.loadExternal("他");
		analyzer.loadExternal("说");
		analyzer.loadExternal("的");
		
		String word = "他说的确实在理";
		
		List<String> rs = analyzer.analyze(word, true);
		
		System.out.println(rs);
	}

}
