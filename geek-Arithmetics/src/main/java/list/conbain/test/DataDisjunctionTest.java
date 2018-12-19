package list.conbain.test;

import list.conbain.array.DataDisjunction;
import list.conbain.array.IntegerDataArray;
import list.conbain.itfc.IDataArray;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-17
 */
public class DataDisjunctionTest {

	public static void main(String[] args) {
		IntegerDataArray a1 = new IntegerDataArray(new Integer[]{1, 5, 7, 11, 15});
		IntegerDataArray a2 = new IntegerDataArray(new Integer[]{2, 3, 5, 11});
		IntegerDataArray a3 = new IntegerDataArray(new Integer[]{5, 11, 12 });
		IntegerDataArray a4 = new IntegerDataArray(new Integer[]{1, 3, 5});
		IntegerDataArray a5 = new IntegerDataArray(new Integer[]{5, 7, 11});
		
		DataDisjunction disjunction = new DataDisjunction(new IDataArray[]{a1, a2, a3, a4, a5}, 4);
		
//		System.out.println("advance : " + disjunction.advance(11));
		
		long data = -1;
		long begin = System.nanoTime();
		while((data = disjunction.nextDoc()) != IDataArray.NO_MORE_DATA) {
			System.out.println(data);
		}
		System.out.println("cost : " + (System.nanoTime() - begin) / (float) 1000000 + " ms");
	}
}
