package ansj.sun.bloomFilter.filter;

public class JSFilter extends AbstractFilter {

	public JSFilter(long maxValue, int MACHINENUM) throws Exception {
		super(maxValue, MACHINENUM);
	}

	public JSFilter(long maxValue) {
		super(maxValue);
	}

	public long myHashCode(String str) {
		int hash = 1315423911;

		for (int i = 0; i < str.length(); i++) {
			hash ^= ((hash << 5) + str.charAt(i) + (hash >> 2));
		}

		return dealHashcode(hash);
	}

}
