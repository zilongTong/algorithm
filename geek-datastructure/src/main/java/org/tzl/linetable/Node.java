package org.tzl.linetable;
/**
 * ������Ľ�� 
 * @author Administrator
 *
 */
public class Node {

//	private Object data;//Ҫ�洢������
//	private  Node  next;
	Object data;//Ҫ�洢������
	Node  next;
	public Node() {
		
	}
	public Node(Object data) {
		super();
		this.data = data;
	}
	public Node(Object data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
