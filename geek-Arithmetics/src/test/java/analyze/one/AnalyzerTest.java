package analyze.one;

import java.io.IOException;
import java.util.List;

import analyze.one.Analyzer;
import analyze.one.Test;

import junit.framework.TestCase;

public class AnalyzerTest extends TestCase {
	
	private static Analyzer analyzer = new Analyzer();
	private static String src = "";
	static {
		try {
			analyzer.initDictMap();
			src = Test.getSrc("test");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testMaxLength() {
		System.out.println("待匹配词汇长度："+src.length());
		long b = System.currentTimeMillis();
		List<String> rs = analyzer.analyze(src, true);
		System.out.println("最大匹配，耗时："+(System.currentTimeMillis() - b));
		System.out.println("匹配到词组数量（可重复）"+rs.size());
		assertEquals(rs.get(rs.size() - 1), "包吃包住");
	}
	public void testMinLength() {
		long b = System.currentTimeMillis();
		List<String> rs = analyzer.analyze(src, false);
		System.out.println("最小匹配，耗时："+(System.currentTimeMillis() - b));
		System.out.println("匹配到词组数量（可重复）"+rs.size());
		assertEquals(rs.get(rs.size() - 1), "包住");
	}
}
