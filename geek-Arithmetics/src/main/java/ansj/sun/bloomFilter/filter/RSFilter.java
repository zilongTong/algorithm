package ansj.sun.bloomFilter.filter;


public class RSFilter extends AbstractFilter {

	public RSFilter(long maxValue, int MACHINENUM) throws Exception {
		super(maxValue, MACHINENUM);
	}

	public RSFilter(long maxValue) {
		super(maxValue);
	}

	public long myHashCode(String str) {
		int b = 378551;
		int a = 63689;
		int hash = 0;

		for (int i = 0; i < str.length(); i++) {
			hash = hash * a + str.charAt(i);
			a = a * b;
		}
		return dealHashcode(hash);
	}

}
