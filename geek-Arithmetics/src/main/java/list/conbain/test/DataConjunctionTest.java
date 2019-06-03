/*
package list.conbain.orion;

import org.junit.Test;

import list.conbain.array.DataConjunction;
import list.conbain.array.IntegerDataArray;
import list.conbain.array.LongDataArray;
import list.conbain.itfc.IDataArray;

*/
/**
 *
 * @author Smile.Wu
 * @version 2015-7-17
 *//*

public class DataConjunctionTest {
	
	public static void main(String[] args) {
		LongDataArray a1 = new LongDataArray(new Long[]{2L, 5L, 9L, 6L, 11L, 17L, 15L, 22L, 209999999999L});
		LongDataArray a2 = new LongDataArray(new Long[]{5L, 22L, 20L, 209999999999L, 24L, 11L, 17L, 2L, 8L});
		LongDataArray a3 = new LongDataArray(new Long[]{1L, 4L, 209999999999L, 5L, 9L, 7L, 17L, 22L, 11L});
		LongDataArray a4 = new LongDataArray(new Long[]{11L, 17L, 15L, 5L, 22L, 25L, 30L, 209999999999L, 32L, 28L});
		LongDataArray a5 = new LongDataArray(new Long[]{5L, 22L, 26L, 11L, 14L, 209999999999L});
		
		DataConjunction conjunction = new DataConjunction(new IDataArray[]{a1, a2, a3, a4});
		
		DataConjunction dataConjunction = new DataConjunction(new IDataArray[]{conjunction, a5});
		
//		System.out.println("advance : " + dataConjunction.advance(18));
		
		long data = -1;
		long begin = System.nanoTime();
		while((data = dataConjunction.nextDoc()) != IDataArray.NO_MORE_DATA) {
			System.out.println(data);
		}
		System.out.println("cost : " + (System.nanoTime() - begin) / (float) 1000000 + " ms");
	}
	
	@Test
	public void test1() {
		//所有DataArray只能用一次，因为其index指针会冲突
		IntegerDataArray a1 = new IntegerDataArray(new Integer[]{1, 5, 6, 11, 15, 18, 22});
		IntegerDataArray a2 = new IntegerDataArray(new Integer[]{11, 12, 18, 25});
		IntegerDataArray a3 = new IntegerDataArray(new Integer[]{1, 2, 3, 11, 18, 30});
		IntegerDataArray a4 = new IntegerDataArray(new Integer[]{1, 5, 6, 11, 18, 19});
		IntegerDataArray a5 = new IntegerDataArray(new Integer[]{11, 12, 15, 18, 22});
		IntegerDataArray a6 = new IntegerDataArray(new Integer[]{1, 7, 11, 12, 13, 18, 26});
		IntegerDataArray a7 = new IntegerDataArray(new Integer[]{1, 3, 10, 11, 17, 18, 22, 30});
		IntegerDataArray a8 = new IntegerDataArray(new Integer[]{4, 8, 11, 17, 18, 25});

		
		DataConjunction conjunction = new DataConjunction(new IDataArray[]{a1, a2, a3, a4, a5, a6, a7, a8});
		
//		System.out.println("advance : " + dataConjunction.advance(18));
		
		long data = -1;
		long begin = System.nanoTime();
		while((data = conjunction.nextDoc()) != IDataArray.NO_MORE_DATA) {
			System.out.println(data);
		}
		System.out.println("cost : " + (System.nanoTime() - begin) / (float) 1000000 + " ms");
	}
}
*/
