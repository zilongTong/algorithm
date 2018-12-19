package sort.listmerge;
/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-26 下午1:19:56 
 */
public class SimilGoodsQueue {
	private final GoodsInverseChain[] heap;
	private final int maxSize;
	private int size;
	private GoodsInverseChain topChain;
	public SimilGoodsQueue(int max) {
		maxSize = max + 1;
		heap = new GoodsInverseChain[maxSize];
		size = 0;
		topChain = heap[1];
	}
	
	public boolean insert(GoodsInverseChain goodsChain) {
		if(size < maxSize) {
			put(goodsChain);
			return true;
		} else if(goodsChain.currentGoodsID() < heap[1].currentGoodsID()) {
			heap[1] = goodsChain;
			adjustTop();
			return true;
		}
		return false;
	}
	
	public void put(GoodsInverseChain goodsChain) {
		size ++;
		heap[size] = goodsChain;
		upheap();
	}
	
	public final boolean topNextAndAdjustElsePop() {
		return checkAdjustOrPop(topChain.nextGoodsId() != GoodsSet.NO_MORE_GOODS);
	}
	public final boolean skipToAndAdjustElsePop(int id) {
		return checkAdjustOrPop(topChain.advance(id) != GoodsSet.NO_MORE_GOODS);
	}
	
	private boolean checkAdjustOrPop(boolean hasResult) {
		if(hasResult) {
			
		} else {
			heap[1] = heap[size];
			heap[size] = null;
			size --;
		}
		if(size > 0) {
			downHeap();
			topChain = heap[1];
		}
		for(int i = 1; i <= size; i ++) {
//			System.out.println(heap[i]+","+heap[i].info());
		}
		return hasResult;
	}
	
	public int topGoodsID() {
		return topChain.currentGoodsID();
	}
	
	public float topGoodsSimil() {
		return topChain.currentGoods().getSimil();
	}
	
	public float topWeight() {
		return topChain.getWeight();
	}
	
	public int size() {
		return size;
	}
	
	public void adjustTop() {
		downHeap();
	}
	
	public void upheap() {
		int i = size;
		GoodsInverseChain node = heap[i];//最后放入的数据
		int nodeID = node.currentGoodsID();
		int j = i >>> 1; //i的父级元素位置
		while(j > 0 && nodeID < heap[j].currentGoodsID()) {
			heap[i] = heap[j];
			i = j;
			j = i >>> 1;
		}
		heap[i] = node;
		topChain = heap[1];
	}
	
	public void downHeap() {
		int i = 1;
		GoodsInverseChain node = heap[i];
		int nodeID = node.currentGoodsID();
		int j = i << 1;
		int k = j + 1;
		
		if(k <= size && heap[k].currentGoodsID() < heap[j].currentGoodsID()) {
			j = k;
		}
		while(j <= size && heap[j].currentGoodsID() < nodeID) {
			heap[i] = heap[j];
			i = j;
			j = i << 1;
			k = j + 1;

			if(k <= size && heap[k].currentGoodsID() < heap[j].currentGoodsID()) {
				j = k;
			}
		}
		heap[i] = node;
		topChain = heap[1];
	}
}
