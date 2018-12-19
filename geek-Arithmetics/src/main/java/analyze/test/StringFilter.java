package analyze.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringFilter {

	public static String code(String s) {
		String rs = "";
		List<Integer> codes = new ArrayList<Integer>();
		for(int i = 0, len = s.length(); i < len; i ++) {
			int cv = s.codePointAt(i);
			if(cv == 32) {
				continue;
			}
			codes.add(cv);
		}
		Collections.sort(codes, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		for(Integer code : codes) {
			rs += String.valueOf(code) + "_";
		}
		return rs;
	}
	
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>(0);
		words.add("休闲男裤");
		words.add("休闲裤 男");
		words.add("男 休闲裤");
		words.add("男休闲裤");
		
		SameWordFilter filter = new SameWordFilter(words);
		
		long b = System.currentTimeMillis();
		for(String word : filter.filter()) {
			System.out.println(word);
		}
		System.out.println(System.currentTimeMillis() - b);
	}
}
