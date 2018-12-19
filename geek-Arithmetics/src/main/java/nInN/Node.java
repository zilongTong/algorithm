package nInN;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2013-1-8 下午3:06:23 
 */
public class Node {

	private int num;
	private boolean isEnd;
	private int sum;
	private Map<Integer, Node> next = new HashMap<Integer, Node>();
	public Node() {
		
	}

	public Node(int n, boolean isEnd, int sum) {
		this.num = n;
		this.isEnd = isEnd;
		this.sum = sum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Map<Integer, Node> getNext() {
		return next;
	}

	public void setNext(Map<Integer, Node> next) {
		this.next = next;
	}
}
