package ansj.sun.bloomFilter.filter;


public class HfIpFilter extends AbstractFilter {
	public HfIpFilter(long maxValue, int MACHINENUM) throws Exception {
		super(maxValue, MACHINENUM);
	}

	public HfIpFilter(long maxValue) {
		super(maxValue);
	}

	public long myHashCode(String str) {
		int length = str.length();
		long hash = 0;
		for (int i = 0; i < length; i++) {
			hash += str.charAt(i % 4) ^ str.charAt(i);
		}

		return dealHashcode(hash);
	}

}
