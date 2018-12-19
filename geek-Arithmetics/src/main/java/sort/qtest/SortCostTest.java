package sort.qtest;


public class SortCostTest {

	public static void testSort(ISort sortType) {
		SortData.init();
		int size = SortData.LARGE_DATA.length;
		long b = System.currentTimeMillis();
		sortType.sort(SortData.LARGE_DATA);
		System.out.println(sortType.getClass().getSimpleName() + ": size=" + size + ", cost=" + (System.currentTimeMillis() - b));
		SortData.print(SortData.LARGE_DATA, 20);
	}

	public static void testSort(ISort sortType, Integer[] array) {
		SortData.init();
		int size = SortData.LARGE_DATA.length;
		long b = System.currentTimeMillis();
		sortType.sort(array);
		System.out.println(sortType.getClass().getSimpleName() + ": size=" + size + ", cost : "+(System.currentTimeMillis() - b));
		SortData.print(SortData.LARGE_DATA, 20);
	}
}
