package analyze.also;

import java.util.ArrayList;
import java.util.List;

import analyze.also.anly.WordAnalyzer;

public class WordAnalyzerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputWord = "春夏 休闲高领";
		List<Word> words = new ArrayList<Word>(0);
		words.add(new Word("运动休闲女装织花毛毛里开衫毛衣"));
		words.add(new Word("男童插肩连帽短打无袖T恤[童装优惠]"));
		words.add(new Word("男童撞色袖棉布茄克"));
		words.add(new Word("女童波点印花针织长袖连帽衫"));
		words.add(new Word("男运动休闲前胸印花连帽针织套头卫衣[元旦限时特价]"));
		
		words.add(new Word("AMPM男基本净色圆领长袖毛衫"));
		words.add(new Word("男一款多花满身印花连帽针织套头卫衣[元旦限时特价]"));
		words.add(new Word("男装圆领间条长袖毛衣[元旦限时特价]"));
		words.add(new Word("男前胸提花条纹圆领长袖毛衣"));
		words.add(new Word("女基本净色高领长袖毛衫（缤纷纯色）"));
		words.add(new Word("女净色立领开衫卫衣"));
		long b = System.currentTimeMillis();
		WordAnalyzer analyzer = new WordAnalyzer(inputWord);
		
		analyzer.initDevices();
		System.out.println(analyzer.get_peopleDevice());
		System.out.println(analyzer.get_seasonDevice()+"\n");
		analyzer.calculate(words);
		for(Word word : words) {
			System.out.println(word.get_value() + "\t\t" + word.get_newWeighing());
		}
		
		System.out.println("\n耗时："+ (System.currentTimeMillis() - b));
		
		System.out.println(analyzer.show());
	}

}
