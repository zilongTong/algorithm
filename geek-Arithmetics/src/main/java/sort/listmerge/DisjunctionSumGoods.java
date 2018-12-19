package sort.listmerge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-26 下午1:15:06 
 */
public class DisjunctionSumGoods {
	private List<GoodsInverseChain> goodsChains;
	private SimilGoodsQueue goodsQueue;
	private int currentID;
	private float currentSimil;
	private int sameNum = 0;
	
	public DisjunctionSumGoods(List<GoodsInverseChain> goodsChains) {
		this.goodsChains = goodsChains;
		initGoodsQueue();
	}
	
	public void initGoodsQueue() {
		goodsQueue = new SimilGoodsQueue(goodsChains.size());
		for(GoodsInverseChain chain : goodsChains) {
			if(chain.nextGoodsId() != GoodsSet.NO_MORE_GOODS) {
				goodsQueue.insert(chain);
			}
		}
	}
	
	public List<GoodsSimilarity> v(int minSize) {
		List<GoodsSimilarity> result = new ArrayList<>();
		while(goodsQueue.size() > 0 && advancedAfterCurrent()) {
			if(sameNum >= minSize) {
				result.add(new GoodsSimilarity(currentID, currentSimil));
			}
		}
		
		Collections.sort(result, new Comparator<GoodsSimilarity>() {
			@Override
			public int compare(GoodsSimilarity o1, GoodsSimilarity o2) {
				if(o2.getSimil() > o1.getSimil()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		return result;
	}
	
	public boolean advancedAfterCurrent() {
		do {
			currentID = goodsQueue.topGoodsID();
			currentSimil = goodsQueue.topGoodsSimil() * goodsQueue.topWeight();
			sameNum = 1;
			do {
				if(!goodsQueue.topNextAndAdjustElsePop() && goodsQueue.size() == 0) {
					break;
				}
				
				if(goodsQueue.topGoodsID() != currentID) {
					break;
				}
				sameNum ++;
				currentSimil += goodsQueue.topGoodsSimil() * goodsQueue.topWeight();
			}while(true);

			return currentID != GoodsSet.NO_MORE_GOODS;
		}while(true);
	}
}
