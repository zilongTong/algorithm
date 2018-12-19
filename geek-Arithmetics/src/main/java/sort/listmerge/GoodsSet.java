package sort.listmerge;
/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-26 上午11:29:54 
 */
public abstract class GoodsSet {
	public static final int NO_MORE_GOODS = Integer.MAX_VALUE;
	
	public abstract int advance(int id);
	
	public abstract int nextGoodsId();
}
