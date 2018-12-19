package ansj.sun.bloomFilter.filter;


public class ELFFilter extends AbstractFilter {

	public ELFFilter(long maxValue, int MACHINENUM) throws Exception {
		super(maxValue, MACHINENUM);
	}

	public ELFFilter(long maxValue) {
		super(maxValue);
	}

	public long myHashCode(String str) {
		long hash = 0;
		long g = 0;
		
		int length = str.length() ;
		for (int i = 0; i < length; i ++) {
			hash = (hash << 4) + str.charAt(i);
			g = hash & 0xF0000000;
			if (g > 0) {
				hash ^= g >> 24;
			}
			hash &= ~g;
		}

		return dealHashcode(hash);
	}

}
