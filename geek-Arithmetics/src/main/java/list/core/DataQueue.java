package list.core;

import list.conbain.itfc.IDataArray;

/**
 *
 * @author Smile.Wu
 * @version 2015-7-17
 * 倒排链表的排队二叉堆；
 * 最小二叉堆
 */
public class DataQueue {

	private IDataArray[] items;
	
	private int maxSize;
	
	private int size;

	public DataQueue(int size) {
		if(size < 1) {
			throw new RuntimeException("argument error [size must greater than 0]!");
		}
		items = new IDataArray[size + 1];
		this.maxSize = size + 1;
		size = 0;
	}
	
	public void insert(IDataArray array) {
		if(size < maxSize) {
			put(array);
		}
	}
	
	public void put(IDataArray array) {
		size ++;
		items[size] = array;
		upHeap();
	}

	public final void upHeap(){
		int i = size;
		IDataArray node = items[i];			//最新插入的数据
		
		int j = i >>> 1;			//父节点位置
		while(j > 0 && node.dataID() < items[j].dataID()){	
			//有父节点,并且要插入的数据比父节点的数据要小,则要交换位置
			items[i] = items[j];		//该节点等于父节点数据
			i = j;						//父节点指针位置，也是node保存的数据当前应该存放的位置
			j = j >>> 1;				//迭代父节点的父节点，以此类推
		}
		items[i] = node;			//要插入的数据放入合适位置
	}

	public final void adjustTop(){
		downHeap();
	}
	
	public void downHeap(){
		int i = 1;
		/*
		 * 刚插入的数据，分别和它的两个子元素比较
		 */
		IDataArray node = items[i]; 	// 第一个元素,也就是刚插入的元素
		int j = i << 1; 		// 第二个元素
		int k = j + 1;			// 第三个元素	
		//存在第三个元素
		if (k <= size && items[k].dataID() < items[j].dataID()) { 
			//标记较小的子节点
			j = k;
		}
		//如果标记是有效下标，而且新插入的数大于其较小的子节点，则交换下标
		while (j <= size && items[j].dataID() < node.dataID()) {
			items[i] = items[j]; // 置换，将j下标的数，放置到i下标上，j下标的数可以失效（新插入数据可能放置到j下标上）
			i = j;//将j的值赋值给i，j的值不变，i指向j
			j = i << 1; //再次寻找j的子节点
			k = j + 1;  
			if (k <= size && items[k].dataID() < items[j].dataID()) {
				//j标记到较小的子节点上
				j = k;	//从扩容点
			}
		}
		items[i] = node;  //将最后一个调整顺序的数据的位置为要插入的数据的合适位置；i下标就是j下标
	}
	
	/**
	 * 堆顶元素对应链表的当前值
	 * @return
	 */
	public long topArrayData() {
		return items[1].dataID();
	}

	public long topArrayData(long data) {
		return items[1].advance(data);
	}
	
	public long size() {
		return size;
	}

	/**
	 * 堆顶元素的链表，指向下一个数字， <br/>
	 * 如果堆顶元素的链表没有下一个数字，则弹出元素 <br/>
	 * 然后将堆进行重排
	 * @return
	 */
	public final boolean topNextAndAdjustElsePop() {
		return size > 0 && checkAdjustOrPop(items[1].nextDoc() != IDataArray.NO_MORE_DATA);
	}
	public final boolean skipToAndAdjustElsePop(long data) {
		return size > 0 && checkAdjustOrPop(items[1].advance(data) != IDataArray.NO_MORE_DATA);
	}
	private boolean checkAdjustOrPop(boolean hasResult) {
		if(hasResult) {	//有数据
			
		} else {	//pop
			items[1] = items[size];
			items[size] = null;
			size --;
		}
		if(size > 0) {
			downHeap();
		}
		return hasResult;
	}
}
