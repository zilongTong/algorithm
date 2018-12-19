package list.conbain.test;

import list.conbain.array.IntegerDataArray;
import list.conbain.array.DataReqExclude;
import list.conbain.itfc.IDataArray;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-17
 */
public class ReqExcludeTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		IntegerDataArray a1 = new IntegerDataArray(new Integer[]{2, 3, 5, 7, 9});
		IntegerDataArray a2 = new IntegerDataArray(new Integer[]{2, 8, 11});
		IntegerDataArray a3 = new IntegerDataArray(new Integer[]{3, 5, 7, 8});
		IntegerDataArray a4 = new IntegerDataArray(new Integer[]{2, 7, 9});
		IntegerDataArray a5 = new IntegerDataArray(new Integer[]{3, 7});

		DataReqExclude reqExclude = new DataReqExclude(a1, a5);
//		System.out.println("advance : " + disjunction.advance(11));
		
		long data = -1;
		long begin = System.nanoTime();
		while((data = reqExclude.nextDoc()) != IDataArray.NO_MORE_DATA) {
			System.out.println(data);
		}
		System.out.println("cost : " + (System.nanoTime() - begin) / (float) 1000000 + " ms");
	}
}
