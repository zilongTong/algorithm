package sort.lucene.inter;
import java.util.Arrays;

import sort.lucene.DataSet;
import sort.lucene.MyScorer;
import sort.lucene.top.LuceneFindTopN;
/**
 * 对有序数组取交集,数组必须按照从小到大排序
 * 模仿Lucene的合并子查询条件结果集
 * 
 * @author Administrator
 *
 */
public class MyConjunctionScorer {
	private MyScorer[] scorers = new MyScorer[2];
	private int length;		// 子评分器个数
	private int first=0;	// 迭代子评分器的起始指针位置
	private int last=-1;	// 迭代子评分器的终止指针位置
	
	private boolean more;	// 是否还有子查询条件以及里面是否还有DocumentID
	private boolean hasInit;// 是否已经初始化	
	private int scorerCounter = 0;
	
	public MyConjunctionScorer() {
		
	}
	
	/**
	 * 添加子查询条件评分器
	 * 
	 * @param scorer
	 */
	public void add(MyScorer scorer){
		needExpansion();
		length++;
		last++;
		scorers[last]=scorer;	
		scorerCounter ++;
	}
	
	public boolean next(){
		if(!hasInit){	//首先初始化
			init();
			hasInit=true;
		}else if(more){
			more=scorers[last].next();	//获得下一个要匹配的数据,也就是上一次获取的结果数据的下一个数据
		}
		return doNext();
		
	}
	
	public int doc(){
		return scorers[first].doc;	//返回交集documentID
	}
	
	public boolean doNext(){
		while(more && scorers[first].doc < scorers[last].doc){	//如果要比较的子查询条件评分器的DocumentID一直比last的DocumentID小则一直迭代
			more = scorers[first].SkipTo(scorers[last].doc);	// 从first中找到比last大的DocumentID
			last = first;										// 则以first为基准跟其他子评分器查询条件进行比较
			first = (first == length-1) ? 0 : first + 1;				// 指针后移，获得其他子查询条件评分器跟last指针位置的子查询条件评分器进行对比
		}
		return more;
	}
	
	/**
	 * 初始化
	 */
	public void init(){
		more=length>0;
		for(int i=0,pos=first;i<length;i++){
			if(!more){
				break;
			}
			more=scorers[pos].next();//获取子查询条件评分器下一个DocumentID,有的话返回true,没有的话则false
			pos=(pos==length-1)?0:pos+1;	//位置叠加,让每个子查询条件评分器可以进行迭代
		}
		if(more){	//如果每个子查询条件评分器里有DocumentID
			sortScorers();	//先对每个子查询条件评分器根据当前的DocumentID进行排序
		}
	}
	
	/**
	 * 排序
	 */
	public void sortScorers(){
		System.out.println("reset scorer size...");
		scorers = Arrays.copyOf(scorers, scorerCounter);
		Arrays.sort(scorers);	//排序
	}
	
	/**
	 * 扩容
	 */
	public void needExpansion(){
		if(length>=scorers.length){
			MyScorer[] tmpScorers=new MyScorer[scorers.length*2];
			System.arraycopy(scorers, 0, tmpScorers,0,length);
			scorers=tmpScorers;
		}
	}
	
	public static void main(String[] args){
	
		long b = System.currentTimeMillis();
		
		//从三个id数组中找出交集
		MyConjunctionScorer conScorer=new MyConjunctionScorer();
		conScorer.add(DataSet.Scorers.sc1);
		conScorer.add(DataSet.Scorers.sc2);
		conScorer.add(DataSet.Scorers.sc3);
		conScorer.add(DataSet.Scorers.sc4);
		conScorer.add(DataSet.Scorers.sc5);
		//获取id值最大的前n个数据
		LuceneFindTopN finder = new LuceneFindTopN(50);
		while(conScorer.next()){
			finder.insert(conScorer.doc());
		}
		
		int rsCount = finder.getSize();
		for(int i = 0; i < rsCount; i ++) {
			System.out.println(finder.pop());
		}
		System.out.println(System.currentTimeMillis() - b);
	}
}