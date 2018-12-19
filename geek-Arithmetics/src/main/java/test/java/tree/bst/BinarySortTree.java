package test.java.tree.bst;

import test.java.tree.AbstractBinaryTree;
import test.java.tree.INodeData;

/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 */
public class BinarySortTree extends AbstractBinaryTree {

	public BinarySortTree(SortTreeNode node) {
		super(node);
	}
	
	/**
	 * node的最小子节点
	 * @param node
	 * @return
	 */
	public SortTreeNode minNode(SortTreeNode node) {
		while(node.getLeftChild() != null) {
			node = node.getLeftChild();
		}
		return node;
	}
	/**
	 * 最大子节点
	 * @param node
	 * @return
	 */
	public SortTreeNode maxNode(SortTreeNode node) {
		while(node.getRightChild() != null) {
			node = node.getRightChild();
		}
		return node;
	}
	/**
	 * 从根节点开始搜索
	 * @param nodeValue
	 * @return
	 */
	public SortTreeNode search(INodeData nodeValue) {
		return search((SortTreeNode) root, nodeValue);
	}
	/**
	 * 从指定节点开始搜索
	 * @param root
	 * @param nodeValue
	 * @return
	 */
	public SortTreeNode search(SortTreeNode root, INodeData nodeValue) {
		if(root.getData().equal(nodeValue) || root == null) {
			return root;
		}
		if(root.getData().greaterThan(nodeValue)) {
			return search(root.getLeftChild(), nodeValue);
		} else {
			return search(root.getRightChild(), nodeValue);
		}
	}
	/**
	 * 前趋节点
	 * @param node
	 * @return
	 */
	public SortTreeNode predecessor(SortTreeNode node) {
		if(node.getLeftChild() != null) {
			//左子节点中最大的节点
			return maxNode(node.getLeftChild());
		}
		
		SortTreeNode parent = node.getParent();
		while(parent != null && parent.getLeftChild() == node) {
			node = parent;
			parent = node.getParent();
		}
		//结果节点为X，X的父节点的右节点为X；或者X=root
		return parent;
	}
	/**
	 * 后缀节点
	 * @param node
	 * @return
	 */
	public SortTreeNode successor(SortTreeNode node) {
		if(node.getRightChild() != null) {
			//右子节点的最小节点
			return minNode(node.getRightChild());
		}
		SortTreeNode parent = node.getParent();
		while(parent != null && parent.getRightChild() == node) {
			node = parent;
			parent = node.getParent();
		}
		//结果节点为X，X的父节点的左节点为X；或者X=root
		return parent;
	}
	/**
	 * 插入节点
	 * @param node
	 */
	public void insert(SortTreeNode node) {
		if(root == null) {
			root = node;
			return;
		}
		SortTreeNodeData nodeValue = node.getData();
		SortTreeNode _root = (SortTreeNode) root, parent = null;
		while(_root != null) {
			parent = _root;
			if(_root.getData().greaterThan(nodeValue)) {
				_root = _root.getLeftChild();
			} else {
				_root = _root.getRightChild();
			}
		}
		
		if(nodeValue.lessThan(parent.getData())) {
			parent.setLeftChild(node);
		} else {
			parent.setRightChild(node);
		}
	}
	/**
	 * 删除节点
	 * @param node
	 */
	public void delete(SortTreeNode node) {
		SortTreeNode left = node.getLeftChild();
		SortTreeNode right = node.getRightChild();
		
		if(left == null && right == null) {//node为叶子节点
			//直接删除当前节点，即当前节点替换为null
			replace(node, null);
			return;
		}
		if(left != null && right != null) {
			//当前节点的前趋节点
			SortTreeNode predecessorNode = predecessor(node);
			
			//将右子节点挂到前趋节点
			predecessorNode.setRightChild(right);

			replace(node, left);
			
			return;
		}

		if(left != null) {
			replace(node, left);
		}
		if(right != null) {
			replace(node, right);
		}
	}
	/*
	 * 节点替换
	 */
	private void replace(SortTreeNode oldNode, SortTreeNode newNode) {
		SortTreeNode parent = oldNode.getParent();
		oldNode.setParent(null);
		if(parent.getLeftChild() == oldNode) {
			parent.setLeftChild(newNode);
		} else {
			parent.setRightChild(newNode);
		}
	}
}
