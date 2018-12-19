package ansj.sun.bloomFilter.filter;


public class HfFilter extends AbstractFilter {

	public HfFilter(long maxValue, int MACHINENUM) throws Exception {
		super(maxValue, MACHINENUM);
	}

	public HfFilter(long maxValue) {
		super(maxValue);
	}

	public long myHashCode(String str) {
		int length = str.length() ;
		long hash = 0;

		for (int i = 0; i < length; i++)
			hash += str.charAt(i) * 3 * i;

		//求余数，保证不会溢出
		return dealHashcode(hash);
	}

}
