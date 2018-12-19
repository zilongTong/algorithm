package test.java.tree.common;

import test.java.tree.AbstractTreeNode;

/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 */
public class CommonTreeNode extends AbstractTreeNode {
	
	protected CommonTreeNodeData data = null;
	
	private CommonTreeNode left;
	private CommonTreeNode right;
	private CommonTreeNode parent;

	public CommonTreeNode(CommonTreeNodeData data) {
		super();
		this.data = data;
	}

	public CommonTreeNode getLeftChild() {
		return left;
	}

	public CommonTreeNode getRightChild() {
		return right;
	}

	public CommonTreeNode getParent() {
		return parent;
	}

	public CommonTreeNodeData cloneData() {
		CommonTreeNodeData clone = new CommonTreeNodeData();
		clone.setString(data.getString());
		return clone;
	}

	public void setLeftChild(AbstractTreeNode node) {
		this.left = (CommonTreeNode) node;
		if(node != null) {
			node.setParent(this);
		}
	}

	public void setRightChild(AbstractTreeNode node) {
		this.right = (CommonTreeNode) node;
		if(node != null) {
			node.setParent(this);
		}
	}

	public void setParent(AbstractTreeNode node) {
		this.parent = (CommonTreeNode) node;
	}

	public CommonTreeNodeData getData() {
		return data;
	}

	public void setData(CommonTreeNodeData data) {
		this.data = data;
	}
}
