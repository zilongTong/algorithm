package ansj.sun.bloomFilter.filter;


public class DefaultFilter extends AbstractFilter {

	public DefaultFilter(long maxValue, int MACHINENUM) throws Exception {
		super(maxValue, MACHINENUM);
	}

	public DefaultFilter(long maxValue) {
		super(maxValue);
	}

	public long myHashCode(String str) {
		long hash = 0;

		for (int i = 0; i < str.length(); i ++) {
			hash = 31 * hash + str.charAt(i);
		}
		
		if(hash < 0){
			hash *= -1 ;
		}

		return dealHashcode(hash);
	}

	public static void main(String[] args) {
		int l = -123123 ;
		System.out.println(Long.MAX_VALUE);
		System.out.println(l&Long.MAX_VALUE);
	}
}
