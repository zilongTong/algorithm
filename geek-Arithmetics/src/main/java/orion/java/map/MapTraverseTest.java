package orion.java.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;




/**
 *
 * @author Smile.Wu
 * @version 2015-11-16
 */
public class MapTraverseTest  {
	private static final int MAX = 1024288;

	private Map<Integer, Integer> map = new HashMap<>(MAX);
//	@Before
	public void init() {
		for(int i = 0; i < MAX; i ++) {
			map.put(i, i);
		}
	}
	
	public long keyIterator(Map<Integer, Integer> map) {
		long begin = System.currentTimeMillis();
		Iterator<Integer> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			map.get(iterator.next());
		}
		return System.currentTimeMillis() - begin;
	}
	public long entryIterator(Map<Integer, Integer> map) {
		long begin = System.currentTimeMillis();
		Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Integer, Integer> en = iterator.next();
			en.getValue();
			en.getKey();
		}
		return System.currentTimeMillis() - begin;
	}
	public long forKeySet(Map<Integer, Integer> map) {
		long begin = System.currentTimeMillis();
		Set<Integer> keys = map.keySet();
		for(Integer key : keys) {
			map.get(key);
		}
		return System.currentTimeMillis() - begin;
	}
	public long mapEntry(Map<Integer, Integer> map) {
		long begin = System.currentTimeMillis();
		for(Map.Entry<Integer, Integer> en : map.entrySet()) {
			en.getKey();
			en.getValue();
		}
		return System.currentTimeMillis() - begin;
	}
	public void run() {
//		console("keyIterator : {}", keyIterator(map));
//		console("entryIterator : {}", entryIterator(map));
//		console("forKeySet : {}", forKeySet(map));
//		console("mapEntry : {}", mapEntry(map));
	}
}
