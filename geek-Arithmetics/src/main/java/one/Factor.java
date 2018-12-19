package one;

public class Factor {

	/**
	 * 求两个数的最新公因数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int minCommonFactor(int a, int b) {
		if(a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		int r = a % b;
		while(r != 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}

	public static int minCommonFactor1(int m, int n) {
		if(m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		int a1 = 1, b = 1,
			a = 0, b1 = 0,
			c = m, d = n;
		
		int q = c / d, r = c % d;
		while(r != 0) {
			c = d;
			d = r;
			int temp = a1;
			
			a1 = a;
			a = temp - q * a;
			
			temp = b1;
			b1 = b;
			b = temp - q * b;
			
			q = c / d;
			r = c % d;
		}
		
		System.out.println(m + n);
		System.out.println("d = " + d);
		System.out.println(d + " = " + a + "*" + m + " + " + b + "*" + n);
		
		return d;
	}
	
	public static void main(String[] args) {
		long b = System.currentTimeMillis();
		System.out.println(minCommonFactor(119, 544));
		System.out.println(minCommonFactor1(1769, 551));
		System.out.println("cost : "+(System.currentTimeMillis() - b));
	}
}
