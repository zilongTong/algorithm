package chaintree;

import java.util.Random;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2013-1-15 上午9:50:56 
 */
public class TTT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		
		double t = r.nextInt(40) - 20;
		
		System.out.println(t);

	}

}
