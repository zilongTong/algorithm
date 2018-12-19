package datastructure.btree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree implements BinaryTree{

	private Node root;//根结点
	//private int size;

	public LinkedBinaryTree() {
		super();
	}

	public LinkedBinaryTree(Node root) {
		super();
		this.root = root;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		System.out.println("二叉树结点个数：");
		return this.size(root);
	}

	private int size(Node root) {
		if(root == null){
			return 0;
		}else{
			//获取左子树的size
			int nl = this.size(root.leftChild);
			//获取右子树的size
			int nr = this.size(root.rightChild);
			//返回左子树、右子树size之和并加1
			return nl+nr+1;
		}
	}

	@Override
	public int getHeight() {
		System.out.println("二叉树的高度是：");
		return this.getHeight(root);
	}

	private int getHeight(Node root){
		if(root == null){
			return 0;
		}else{
			//获取左子树的高度
			int nl = this.getHeight(root.leftChild);
			//获取右子树的高度
			int nr = this.getHeight(root.rightChild);
			//返回左子树、右子树较大高度并加1
			return nl > nr ? nl+1:nr+1;
		}
	}

	@Override
	public Node findKey(int value) {

		return this.findKey(value, root);
	}

	public Node findKey(Object value,Node root) {

		if(root == null){//递归结束条件1：结点为空，可能是整个树的根节点，也可能是递归调用中叶子节点中左孩子和右孩子
			return null;
		}else if(root != null && root.value == value){//递归的结束条件2：找到了
			return root;
		}else {//递归体
			Node node1 = this.findKey(value, root.leftChild);
			Node node2 = this.findKey(value, root.rightChild);
			if(node1 != null && node1.value == value){
				return node1;
			}else if(node2 != null && node2.value == value){
				return node2;
			}else{
				return null;
			}
		}

	}

	@Override
	public void preOrderTraverse() {
		if(root != null){
			//1.输出根结点的值
			System.out.print(root.value+"  ");
			//2.对左子树进行先序遍历
			//构建一个二叉树，根是左子树的根
			BinaryTree  leftTree = new LinkedBinaryTree(root.leftChild);
			leftTree.preOrderTraverse();
			//对右子树进行先序遍历
			//3.构建一个二叉树，根是左子树的根
			BinaryTree  rightTree = new LinkedBinaryTree(root.rightChild);
			rightTree.preOrderTraverse();
		}

	}

	@Override
	public void inOrderTraverse() {
		System.out.println("中序遍历");
		this.inOrderTraverse(root);
		System.out.println();

	}

	private void inOrderTraverse(Node root) {//node7
		if(root != null){
			//遍历左子树
			this.inOrderTraverse(root.leftChild);//null
			//输出根的值
			System.out.print(root.value+"  ");//7
			//遍历右子树
			this.inOrderTraverse(root.rightChild);//null
		}
	}

	@Override
	public void postOrderTraverse() {
		System.out.println("后序遍历");
		this.postOrderTraverse(root);
		System.out.println();

	}

	@Override
	public void postOrderTraverse(Node node) {
		if(node != null){
			//遍历左子树
			this.postOrderTraverse(node.leftChild);
			//遍历右子树
			this.postOrderTraverse(node.rightChild);
			//输出根的值
			System.out.print(node.value+"  ");
		}

	}

	@Override
	public void inOrderByStack() {
		System.out.println("中序非递归遍历:");
		// 创建栈
		Deque<Node> stack = new LinkedList<Node>();
		Node current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.leftChild;
			}

			if (!stack.isEmpty()) {
				current = stack.pop();
				System.out.print(current.value + " ");
				current = current.rightChild;
			}
		}
		System.out.println();

	}

	@Override
	public void preOrderByStack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postOrderByStack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void levelOrderByStack() {
		System.out.println("按照层次遍历二叉树");
		if(root == null) return;
		Queue<Node> queue = new LinkedList<Node>() ;
		queue.add(root);
		while(queue.size() != 0)
		{
			int len = queue.size();
			for(int i=0;i <len; i++)
			{
				Node temp = queue.poll();
				System.out.print(temp.value+" ");
				if(temp.leftChild != null)  queue.add(temp.leftChild);
				if(temp.rightChild != null) queue.add(temp.rightChild);
			}
		}

		System.out.println();

	}

}
