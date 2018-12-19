package test.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 */
public abstract class AbstractBinaryTree {
	
	protected AbstractTreeNode root = null;
	
	public AbstractBinaryTree(AbstractTreeNode root) {
		super();
		this.root = root;
	}

	public List<NodeData> preorderTraversal() {
		List<NodeData> result = new ArrayList<NodeData>();
		preorder(root, result);
		return result;
	}

	public List<NodeData> inorderTraversal() {
		List<NodeData> result = new ArrayList<NodeData>();
		intorder(root, result);
		return result;
	}

	public List<NodeData> postorderTraversal() {
		List<NodeData> result = new ArrayList<NodeData>();
		postorder(root, result);
		return result;
	}

	private void preorder(AbstractTreeNode node, List<NodeData> list) {
		if(node != null){
			list.add(node.cloneData());
			preorder(node.getLeftChild(), list);
			preorder(node.getRightChild(), list);
		}
	}
	private void intorder(AbstractTreeNode node, List<NodeData> list) {
		if(node != null){
			intorder(node.getLeftChild(), list);
			list.add(node.cloneData());
			intorder(node.getRightChild(), list);
		}
	}
	private void postorder(AbstractTreeNode node, List<NodeData> list) {
		if(node != null){
			postorder(node.getLeftChild(), list);
			postorder(node.getRightChild(), list);
			list.add(node.cloneData());
		}
	}
}
