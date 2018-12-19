package sort.listmerge.test;

import java.util.ArrayList;
import java.util.List;

import sort.listmerge.DisjunctionSumGoods;
import sort.listmerge.GoodsInverseChain;
import sort.listmerge.GoodsSimilarity;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-26 下午2:41:56 
 */
public class MainTest {
	public static void main(String[] args) {
		GoodsInverseChain chain1 = TestData.getBuy();
		GoodsInverseChain chain2 = TestData.getCommon();
		GoodsInverseChain chain3 = TestData.getLove();
		GoodsInverseChain chain4 = TestData.getView();

		List<GoodsInverseChain> chains = new ArrayList<GoodsInverseChain>(4);
		chains.add(chain1);
		chains.add(chain2);
		chains.add(chain3);
		chains.add(chain4);
		
		long b = System.currentTimeMillis();
		DisjunctionSumGoods disjunctionSumGoods = new DisjunctionSumGoods(chains);
		
		List<GoodsSimilarity> list = disjunctionSumGoods.v(4);
		if(list != null) {
			for(GoodsSimilarity gs : list) {
				System.out.println(gs);
			}
		}
		System.out.println("cost : "+(System.currentTimeMillis() - b));
		
	}
}
