package ansj.sun.bloomFilter.filter;


public class FNVFilter extends AbstractFilter {

	public FNVFilter(long maxValue, int MACHINENUM) throws Exception {

		super(maxValue, MACHINENUM);
	}

	public FNVFilter(long maxValue) {
		super(maxValue);
	}

	private static final int p = 16777619;

	public long myHashCode(String str) {
		long hash = 2166136261L;
		for (int i = 0; i < str.length(); i++)
			hash = (hash * p) ^ str.charAt(i);
		hash += hash << 13;
		hash ^= hash >> 7;
		hash += hash << 3;
		hash ^= hash >> 17;
		hash += hash << 5;

		return dealHashcode(hash);
	}

}
