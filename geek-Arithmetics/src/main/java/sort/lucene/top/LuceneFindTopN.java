package sort.lucene.top;

/**
 * 在一对数中找出前N个大的数,采用二叉堆<br />
 * 此为最小二叉堆，即最顶层的元素最小，当超过size的数大于最小元素时，需要重排。也就是说，这里的最小堆算法是获取前size个最大的元素<br />
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
			heap[i] = heap[j];			//父节点的数据放置在当前位置
			i = j;						//当前指针指向原来的父节点
			j = i >>> 1;				//迭代寻找当前位置的父节点，继续比较
		}
		heap[i] = node;			//要插入的数据放入合适位置（当前位置）
	}
	
	/**
	 * 弹出数据,从最小的元素开始排放,会删除该元素
	 * @return
	 */
	public int pop(){
		if(size > 0){
			int result = heap[1];	//第一个元素作为结果返回,因为第一个元素最小
			heap[1] = heap[size];	//第一个元素置为最大的元素
			heap[size] = -1;		//最大的元素清空
			size --;				//数组大小减一
			downHeap();				//堆顶不是最小值，需要沉降
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
		int node = heap[i]; 	// 堆顶元素,也就是刚插入的元素
		int j = i << 1; 		// 子元素1
		int k = j + 1;			// 子元素2
		//存在第三个元素
		if (k <= size && heap[k] < heap[j]) { 
			//让j指向两个子元素中较小的一个
			j = k;
		}
		while (j <= size && heap[j] < node) {//如果子元素小于新插入的元素，即新元素要和子元素换位置
			heap[i] = heap[j]; //较小子元素放置到当前位置
			i = j;		//当前位置指向较小的子元素，此时这个位置的值已经不需要了
			j = i << 1; //再让j指向当前位置的子元素1
			k = j + 1;  //k指向子元素2
			if (k <= size && heap[k] < heap[j]) { 
				//让j指向两个子元素中较小的一个
				j = k;
			}
		}
		heap[i] = node;  //最后将新插入的元素放置在当前的位置上，此时该位置的元素已经放置在它的父元素位置上了
		
	}
	
	public void print(){
		for(int i = 1; i <= maxSize; i ++){
			System.out.println(heap[i]);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		LuceneFindTopN find=new LuceneFindTopN(20);
//		int[] source={44,65,23,45,55,78,21,32,43,876,1,66,13,35,38,96,437,55,980,21,1010,1001,1334,42,2354,7788,344,333,557,5454,7664,1235};
//		int maxNum = 100000;
//		long b = System.currentTimeMillis();
////		maxNum = source.length;
//		for(int i = 0; i < maxNum; i ++){
//			int a=(int)(Math.random()*maxNum);
////			int a=source[i];
//			find.insert(a);
////			System.out.println(find.insert(a)+":"+a);
//		}
//		
//		System.out.println("================================");
//		/*find.print();*/
//		int max=find.getSize();
//		for(int i=0;i<max;i++){
//			System.out.println(find.pop());
//		}
//		System.out.println("cost : " + (System.currentTimeMillis() - b));
		long i = -2;
		String s1 = Long.toBinaryString(i);
		System.out.println(s1);
		String rs = ("0" + s1).substring(0, s1.length());
		String rs1 = ("1" + s1).substring(0, s1.length());
		System.out.println("i >>> 1 = " + rs);
		System.out.println(i >>> 1);
		System.out.println(Long.parseLong(rs, 2));
		System.out.println();
		System.out.println("i >> 1 = " + rs1);
		System.out.println(i >> 1);
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