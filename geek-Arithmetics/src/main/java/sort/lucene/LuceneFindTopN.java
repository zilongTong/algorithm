package sort.lucene;

/**
 * 在一对数中找出前N个大的数,采用二叉堆
 * 模仿Lucene中的获得评分前N的DocumentID
 * 
 * @author Administrator
 *
 */
public class LuceneFindTopN {
	private int[] heap; 	//存储数据
	private int size;		//已存数据个数,也代表指针位置
	private int maxSize;	//取前maxSize大的数
	private int minElement;	//数据中最小的元素

	
	public LuceneFindTopN(int maxSize) {
		super();
		this.maxSize = maxSize;
		heap = new int[maxSize+1];
		size = 0;
		minElement = 0;
	}
	/**
	 * 插入数据
	 * @param element
	 * @return
	 */
	public boolean insert(int element){
		//未达到指定数据数量
		if(size < maxSize){
			put(element);
			return true;
		}else if(size > 0 && element > top()){ //新数据大于最小的元素才进入,并调整数据顺序
			heap[1] = element;	//替换头部元素(也就是最小的元素)为当前元素(因为当前元素比头部元素大)
			adjustTop();		//调整头部元素
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 存入数据
	 * @param element
	 */
	public void put(int element){
		size ++;
		heap[size] = element;
		upheap();
	}
	/**
	 * 返回top
	 * 最小数据保存在根节点
	 * @return
	 */
	public int top(){
		if(size > 0){
			return heap[1];
		}else{
			return 0;
		}
	}
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public final void upheap(){
		int i = size;
		int node = heap[i];			//最新插入的数据
		int j = i >>> 1;			//父节点位置
		
		while(j > 0 && node < heap[j]){	//有父节点,并且要插入的数据比父节点的数据要小,则要交换位置
			heap[i] = heap[j];			//该节点等于父节点数据
			i = j;						//父节点指针位置，也是node保存的数据当前应该存放的位置
			j = j >>> 1;				//迭代父节点的父节点，以此类推
		}
		heap[i] = node;			//要插入的数据放入合适位置
	}
	
	/**
	 * 排放数据,从最小的元素开始排放,会删除该元素
	 * @return
	 */
	public int pop(){
		if(size > 0){
			int result = heap[1];	//第一个元素作为结果返回,因为第一个元素最小
			heap[1] = heap[size];	//第一个元素置为最大的元素
			heap[size] = -1;		//最大的元素清空
			size --;				//指针前移
			downHeap();
			return result;
		}else{
			return -1;
		}
	}
	
	public final void adjustTop(){
		downHeap();
	}
	/**
	 * 往下沉降，替换了头部的数据后需要根据二叉堆的规则重排数据
	 * 保证根数据是最小的数据
	 */
	public void downHeap(){
		int i = 1;
		/*
		 * 刚插入的数据，分别和它的两个子元素比较
		 */
		int node = heap[i]; 	// 第一个元素,也就是刚插入的元素
		int j = i << 1; 		// 第二个元素
		int k = j + 1;			// 第三个元素	
		//存在第三个元素
		if (k <= size && heap[k] < heap[j]) { //如果当前数据大于等于3个,并且第三个数据小于第二个数据,则从第三个元素开始循环调整顺序,否则从第二个元素开始循环调整排序,如此可以少排一个并且可以扩容一倍
			j = k;
		}
		while (j <= size && heap[j] < node) {	//一直循环，直到超出size(也就是数组大小)并且小于要插入的节点
			heap[i] = heap[j]; // 置换
			i = j;
			j = i << 1; //再乘以2(扩容一倍)
			k = j + 1;  
			if (k <= size && heap[k] < heap[j]) { //没有超过size并且扩容一倍的数大于扩容一倍+1的数(也就是这2个数没有按照从小到大排序)，则从扩容点开始又重新计算
				j = k;	//从扩容点
			}
		}
		heap[i] = node;  //将最后一个调整顺序的数据的位置为要插入的数据的合适位置
		
	}
	
	public void print(){
		for(int i = 1; i <= maxSize; i ++){
			System.out.println(heap[i]);
		}
	}
	
	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		LuceneFindTopN find=new LuceneFindTopN(20);
		int[] source={44,65,23,45,55,78,21,32,43,876,1,66,13,35,38,96,437,55,980,21,1010,1001,1334,42,2354,7788,344,333,557,5454,7664,1235};
		int maxNum = 1000;
//		maxNum = source.length;
		for(int i = 0; i < maxNum; i ++){
			int a=(int)(Math.random()*maxNum);
//			int a=source[i];
			find.insert(a);
//			System.out.println(find.insert(a)+":"+a);
		}
		
		long b = System.currentTimeMillis();
		System.out.println("================================");
		/*find.print();*/
		int max=find.getSize();
		for(int i=0;i<max;i++){
			System.out.println(find.pop());
		}
		System.out.println("cost : " + (System.currentTimeMillis() - b));
	}
	public int[] getHeap() {
		return heap;
	}
	public void setHeap(int[] heap) {
		this.heap = heap;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public int getMinElement() {
		return minElement;
	}
	public void setMinElement(int minElement) {
		this.minElement = minElement;
	}

}