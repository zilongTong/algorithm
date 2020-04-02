package org.tzl.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class TestCollection {

	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		set.add("aaa");
		set.size();
		set.clear();
		
		
		HashSet set2 = new HashSet();
		set2.add("abc");
		set2.size();
		set2.clear();
		set2.isEmpty();
		
		HashMap map = new HashMap();
		map.put("cn", "China");
		map.put("us", "USA");
		map.put("us", "America");
		map.get("cn");
	}
}
