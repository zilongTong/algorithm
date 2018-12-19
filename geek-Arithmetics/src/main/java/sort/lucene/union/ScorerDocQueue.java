package sort.lucene.union;

import sort.lucene.MyScorer;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-3-31 上午9:36:09 
 * 
 * 最小堆,获取前size个最小的元素
 */
public class ScorerDocQueue {

	private MyScorer[] heap; 	//存储数据
	private int size;			//已存数据个数,也代表指针位置
	private int maxSize;		//取前maxSize大的数
	
	public ScorerDocQueue(int initSize) {
		maxSize = initSize;
		
		heap = new MyScorer[initSize + 1];
		size = 0;
	}

	public void insertScorer(MyScorer scorer) {
		if( size < maxSize ) {
			put(scorer);
		}
	}
	
	public void put(MyScorer scorer) {
		size ++;
		heap[size] = scorer;

		upheap();
	}
	
	public final void upheap() {
		int i = size;
		MyScorer lastNode = heap[i];
		int j = i >>> 1;
		
		while(j > 0 && lastNode.doc < heap[j].doc) {
			heap[i] = heap[j];
			i = j;
			j = j >>> 1;
		}
		heap[i] = lastNode;
	}
	
	public final void downheap() {
		int i = 1;
		MyScorer topNode = heap[size];
		int j = i << 1;
		int k = j + 1;
		
		if(k < size && heap[k].doc < heap[j].doc) {
			j = k;
		}
		while(j < size && heap[j].doc < topNode.doc) {
			heap[i] = heap[j];
			i = j;
			j = j << 1;
			k = j + 1;
			
			if(k < size && heap[k].doc < heap[j].doc) {
				j = k;
			}
		}
		heap[i] = topNode;
	}
	
	public MyScorer pop() {
		if(size > 0) {
			MyScorer rs = heap[1];
			heap[1] = heap[size];
			size --;
			downheap();
			return rs;
		}
		return null;
	}
	
	public void show() {
		MyScorer mScorer = null;
		while((mScorer = pop()) != null) {
			mScorer.show();
			System.out.println();
		}
	}
}
