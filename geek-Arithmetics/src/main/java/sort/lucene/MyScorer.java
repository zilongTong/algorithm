package sort.lucene;

import java.util.Arrays;

/**
 * 模仿Lucene的TermScorer(子查询条件评分器)
 * 
 * @author Administrator
 *
 */
public class MyScorer implements Comparable<MyScorer> {
	
	private int[] docs;		//所有DocumentID
	public int doc;			//当前DocumentID
	private int pointer;	//当前指针
	private int pointerMax;	//所允许的最大范围
	
	/**
	 * 获得当前指针位置
	 * @return
	 */
	public int getPointer() {
		return pointer;
	}
	
	/**
	 * 比较两个MyScorer大小,通过当前DocumentID进行比较
	 */
	public int compareTo(MyScorer o) {
		if(o == null) {
			return 0;
		}
		if(o instanceof MyScorer){
			return this.doc - o.doc;
		}
		return 0;
	}
	
	public MyScorer(int[] docs) {
		super();
		this.docs = docs;
		doc=-1;
		pointer=-1;
		pointerMax=docs.length;
		Arrays.sort(docs);
	}
	
	/**
	 * 获取下一个DocumentID
	 * @return
	 */
	public boolean next(){
		pointer ++;
		if(pointer >= pointerMax){
			pointer = 0;
			return false;
		}
		doc = docs[pointer];
		return true;
	}
	
	/**
	 * 指针跳转到大于或等于目标documentID值,然后接下来可以通过指针位置获取该值
	 * @param target
	 * @return
	 */
	public boolean SkipTo(int target){
		for(pointer ++; pointer < pointerMax; pointer ++){
			if(docs[pointer] >= target){
				doc = docs[pointer];
				return true;
			}
		}
		return false;
	}

	public int[] getDocs() {
		return docs;
	}

	public void setDocs(int[] docs) {
		this.docs = docs;
	}
	
	public void show() {
		for(int i : docs) {
			System.out.print(i + ",");
		}
	}
}