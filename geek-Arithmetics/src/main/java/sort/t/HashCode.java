package sort.t;
/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-27 上午8:45:23 
 */
public class HashCode {
	
	public static long code(String input) {
		if(input == null || input.length() == 0) {
			return 0;
		}
		char[] vals = input.toCharArray();
		long h = 0;
		for(int i = 0, len = input.length(); i < len; i ++) {
			char temp = vals[i];
			h = h * (i + 1) + temp;
		}
		return h;
	}

	public static void main(String[] args) {
		String t = new String("阿萨德发发是短发散发法撒旦法sdfsdfsdfsdfsdfsdf");
		
		System.out.println(code(t));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		System.out.println(Math.pow(31, 31));
	}
}
