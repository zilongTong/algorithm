package list.conbain.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import list.conbain.array.IntegerDataArray;
import list.conbain.itfc.IDataArray;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-17
 */
public class DataCreator {

	public static IDataArray create(int size) {
		return new IntegerDataArray(createArray(size));
	}
	
	public static int seed = 1;
	
	public static Integer[] createArray(int size) {
		List<Integer> list = new ArrayList<>();
		int count = 0;
		int last = 10;
		while(count ++ < size) {
			Random r = new Random(System.currentTimeMillis() + count + seed ++);
			
			last = r.nextInt(5) + last + 1;
			list.add(last);
		}
		return list.toArray(new Integer[]{});
	}

	public synchronized static Long[] createLongArray(int size) {
		List<Long> list = new ArrayList<Long>();
		int count = 0;
		long last = 10;
		while(count ++ < size) {
			Random r = new Random(System.currentTimeMillis() + count + seed ++);
			
			last = r.nextInt(5) + last + 1;
			list.add(last);
		}
		return list.toArray(new Long[]{});
	}
	
	public static void main(String[] args) {
		long begin = System.nanoTime();
		create(10000);
		System.out.println("cost : " + (System.nanoTime() - begin) / (float) 1000000 + " ms");
	}
}
