package ansj.sun.bloomFilter.filter;

public class SDBMFilter extends AbstractFilter {

	public SDBMFilter(long maxValue, int MACHINENUM) throws Exception {
		super(maxValue, MACHINENUM);
	}

	public SDBMFilter(long maxValue) {
		super(maxValue);
	}

	public long myHashCode(String str) {
		int hash = 0;

		for (int i = 0; i < str.length(); i++) {
			hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash;
		}

		return dealHashcode(hash);
	}

}
