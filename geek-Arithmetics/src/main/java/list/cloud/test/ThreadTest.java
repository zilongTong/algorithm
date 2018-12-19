package list.cloud.test;

import list.cloud.MultiThreadQuery;
import list.conbain.array.DataDisjunction;
import list.conbain.itfc.IDataArray;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-20
 */
public class ThreadTest {
	

	public static void main(String[] args) throws InterruptedException {
		MultiThreadQuery multiThreadQuery = new MultiThreadQuery();
		
		multiThreadQuery.executeQuery(new IdQueryTest1());
		multiThreadQuery.executeQuery(new IdQueryTest1());
		multiThreadQuery.executeQuery(new IdQueryTest2());
		multiThreadQuery.executeQuery(new IdQueryTest2());
//		multiThreadQuery.executeQuery(new IdQueryTest2());
//		multiThreadQuery.executeQuery(new IdQueryTest2());

		long begin = System.nanoTime();
//		DataConjunction conjunction = multiThreadQuery.waitAndProcess();
		DataDisjunction conjunction = multiThreadQuery.waitAndProcess(4);
		double cost = (System.nanoTime() - begin) / (float) 1000000;
		
		long data = 0L;

		int c = 0;
		while((data = conjunction.nextDoc()) != IDataArray.NO_MORE_DATA) {
			System.out.println(data);
			c ++;
		}
		System.out.println("data size : " + c);
//		System.out.println("result arrays size : " + conjunction.size());
		System.out.println("cost : " + cost + " ms");
	}
}
