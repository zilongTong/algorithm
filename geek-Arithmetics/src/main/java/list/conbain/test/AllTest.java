/*
package list.conbain.test;

import java.util.HashSet;
import java.util.Set;

import list.conbain.array.DataConjunction;
import list.conbain.array.DataDisjunction;
import list.conbain.array.IntegerDataArray;
import list.conbain.array.DataReqExclude;
import list.conbain.itfc.IDataArray;

import org.junit.Test;

*/
/**
 *
 * @author Smile.Wu
 * @version 2015-7-17
 *//*

public class AllTest {

	@Test
	public void testDataConjunction() {
		int arraySize = 1000000;
		IDataArray a1 = DataCreator.create(arraySize);
		IDataArray a2 = DataCreator.create(arraySize);
		IDataArray a3 = DataCreator.create(arraySize);
		IDataArray a4 = DataCreator.create(arraySize);
		DataConjunction conjunction = new DataConjunction(new IDataArray[]{a1, a2, a3, a4});

		long data = -1;
		long begin = System.nanoTime();
		int c = 0;
		while((data = conjunction.nextDoc()) != IDataArray.NO_MORE_DATA) {
			System.out.println(data);
			c ++;
		}
		System.out.println("get : " + c + ", cost : " + (System.nanoTime() - begin) / (float) 1000000 + " ms");
	}

	@Test
	public void testDataConjunctionMixIntegerDataArray() {
		int arraySize = 1000000;
		IDataArray a1 = DataCreator.create(arraySize);
		IDataArray a2 = DataCreator.create(arraySize);
		IDataArray a3 = DataCreator.create(arraySize);
		IDataArray a4 = DataCreator.create(arraySize);
		DataConjunction conjunction = new DataConjunction(new IDataArray[]{a1, a2, a3});
		
		DataConjunction dataConjunction = new DataConjunction(new IDataArray[]{a4, conjunction});

		long data = -1;
		long begin = System.nanoTime();
		int c = 0;
		while((data = dataConjunction.nextDoc()) != IDataArray.NO_MORE_DATA) {
			System.out.println(data);
			c ++;
		}
		System.out.println("get : " + c + ", cost : " + (System.nanoTime() - begin) / (float) 1000000 + " ms");
	}

	@Test
	public void testDataDisjunction() {
		int arraySize = 100000;
		IDataArray a1 = DataCreator.create(arraySize);
		IDataArray a2 = DataCreator.create(arraySize);
		IDataArray a3 = DataCreator.create(arraySize);
		IDataArray a4 = DataCreator.create(arraySize);
		DataDisjunction disjunction = new DataDisjunction(new IDataArray[]{a1, a2, a3, a4}, 3);
		
		long data = -1;
		long begin = System.nanoTime();
		int c = 0;
		while((data = disjunction.nextDoc()) != IDataArray.NO_MORE_DATA) {
			System.out.println(data);
			c ++;
		}
		System.out.println("get : " + c + ", cost : " + (System.nanoTime() - begin) / (float) 1000000 + " ms");
	}


	@Test
	public void testReqExclude() {
		int arraySize = 100000;
		IDataArray a1 = DataCreator.create(arraySize);
		IDataArray a2 = DataCreator.create(arraySize);
		IDataArray a3 = DataCreator.create(arraySize);
		IDataArray a4 = DataCreator.create(arraySize);
		
		DataReqExclude reqExclude1 = new DataReqExclude(a1, a2);
		DataReqExclude reqExclude2 = new DataReqExclude(reqExclude1, a3);
		DataReqExclude reqExclude = new DataReqExclude(reqExclude2, a4);
		
		long data = -1;
		long begin = System.nanoTime();
		int c = 0;
		while((data = reqExclude.nextDoc()) != IDataArray.NO_MORE_DATA) {
			System.out.println(data);
			c ++;
		}
		System.out.println("get : " + c + ", cost : " + (System.nanoTime() - begin) / (float) 1000000 + " ms");
	}
	
	public boolean testEqual(IDataArray a, IDataArray b) {
		long data = IDataArray.NO_MORE_DATA;
		Set<Long> filtera = new HashSet<>();
		while((data = a.nextDoc()) != IDataArray.NO_MORE_DATA) {
			filtera.add(data);
		}
		
		data = IDataArray.NO_MORE_DATA;
		Set<Long> filterb = new HashSet<>();
		while((data = b.nextDoc()) != IDataArray.NO_MORE_DATA) {
			filterb.add(data);
		}
		
		if(filtera.size() != filterb.size()) {
			return false;
		}

		if(filtera.size() < filterb.size()) {
			Set<Long> temp = filtera;
			filtera = filterb;
			filterb = temp;
		}
		
		for(Long i : filterb) {
			if(filtera.contains(i)) {
				filtera.remove(i);
			}
		}
		return filtera.size() == 0;
	}
	public void showArray(String tag, Integer[] arr) {
		StringBuilder sb = new StringBuilder("");
		for(Integer i : arr) {
			sb.append(i).append(" ");
		}
		System.out.println(tag + " : " + sb);
	}
	@Test
	public void testMix() {
		int arraySize = 1000000;
		Integer[] a1 = DataCreator.createArray(arraySize);
		Integer[] a2 = DataCreator.createArray(arraySize);
		Integer[] a3 = DataCreator.createArray(arraySize);
		Integer[] a4 = DataCreator.createArray(arraySize);
		
		System.out.println("a1 & a2 & a3 & a4 == (a1 & a2) & (a3 & a4) : " + testEqual(new DataConjunction(new IDataArray[]{
						new DataConjunction(new IDataArray[]{
								new IntegerDataArray(a1),
								new IntegerDataArray(a2)
						}),
						new DataConjunction(new IDataArray[]{
								new IntegerDataArray(a3),
								new IntegerDataArray(a4)
						})
				}),
				new DataConjunction(new IDataArray[]{
						new IntegerDataArray(a1),
						new IntegerDataArray(a2),
						new IntegerDataArray(a3),
						new IntegerDataArray(a4)
				})));
		
		System.out.println("a1 - a2 - a3 - a4 == a1 - (a2 + a3 +a4) : " + testEqual(
				new DataReqExclude(
							new DataReqExclude(
										new DataReqExclude(new IntegerDataArray(a1), new IntegerDataArray(a2)), 
										new IntegerDataArray(a3)), 
							new IntegerDataArray(a4)), 
				
				new DataReqExclude(new IntegerDataArray(a1), new DataDisjunction(new IDataArray[]{
						new IntegerDataArray(a2),
						new IntegerDataArray(a3),
						new IntegerDataArray(a4)
				}, 1))));
		
		
//		IDataArray array = null;
//		int d = -1;
//		
//		array = new DataDisjunction(new IDataArray[]{
//				new IntegerDataArray(a2),
//				new IntegerDataArray(a3),
//				new IntegerDataArray(a4)
//		}, 1);
//		List<Integer> temp = new ArrayList<>();
//		while((d = array.nextDoc()) != IDataArray.NO_MORE_DATA) {
//			temp.add(d);
//		}
//		Integer[] b = temp.toArray(new Integer[]{});
//		showArray("b", b);
//		
//		System.out.println();
//		
//		System.out.println();
//		array = new ReqExclude(new IntegerDataArray(a1), new IntegerDataArray(b));
//		d = -1;
//		while((d = array.nextDoc()) != IDataArray.NO_MORE_DATA) {
//			System.out.println(d);
//		}
//		System.out.println();
//		
//		array = new ReqExclude(new IntegerDataArray(a1), new DataDisjunction(new IDataArray[]{
//				new IntegerDataArray(a2),
//				new IntegerDataArray(a3),
//				new IntegerDataArray(a4)
//		}, 1));	
//		
//		d = -1;
//		while((d = array.nextDoc()) != IDataArray.NO_MORE_DATA) {
//			System.out.println(d);
//		}
//		System.out.println();
	}
}
*/
