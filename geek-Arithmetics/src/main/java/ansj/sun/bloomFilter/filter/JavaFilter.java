package ansj.sun.bloomFilter.filter;


public class JavaFilter extends AbstractFilter {

	public JavaFilter(long maxValue, int MACHINENUM) throws Exception {
		super(maxValue, MACHINENUM);
	}

	public JavaFilter(long maxValue) {
		super(maxValue);
	}

	public long myHashCode(String str) {
		long hash = 0;

		for (int i = 0; i < str.length(); i ++) {
			hash = 131 * hash + str.charAt(i);
		}

		return dealHashcode(hash);
	}

}
