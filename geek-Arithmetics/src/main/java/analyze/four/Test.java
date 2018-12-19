package analyze.four;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		Analyzer analyzer = new Analyzer();
		analyzer.loadExternal("美邦:美特斯邦威");
		analyzer.loadExternalWord("邦威", "metersbonwe");
		analyzer.loadExternalWord("童鞋", "童 鞋");
		long b = System.currentTimeMillis();
		String t = "童鞋123童装美邦邦威";
		System.out.println(analyzer.replace(t, true));
		System.out.println(System.currentTimeMillis() - b);
	}
}
