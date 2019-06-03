package orion.java.tree.bst;

import orion.java.tree.AbstractTreeNode;


/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 */
public class SortTreeNode extends AbstractTreeNode {

	public SortTreeNode(SortTreeNodeData data) {
		this.data = data;
	}
	private SortTreeNodeData data = null;
	private SortTreeNode left;
	private SortTreeNode right;
	private SortTreeNode parent;
	
	public SortTreeNodeData getData() {
		return data;
	}
	public void setData(SortTreeNodeData data) {
		this.data = data;
	}
	public SortTreeNode getLeftChild() {
		return left;
	}
	public void setLeftChild(AbstractTreeNode left) {
		this.left = (SortTreeNode) left;
		if(left != null) {
			left.setParent(this);
		}
	}
	public SortTreeNode getRightChild() {
		return right;
	}
	public void setRightChild(AbstractTreeNode right) {
		this.right = (SortTreeNode) right;
		if(right != null) {
			right.setParent(this);
		}
	}
	public SortTreeNode getParent() {
		return parent;
	}
	public void setParent(AbstractTreeNode parent) {
		this.parent = (SortTreeNode) parent;
	}
	
	@Override
	public SortTreeNodeData cloneData() {
		SortTreeNodeData clone = new SortTreeNodeData(getData().getValue());
		clone.setString(data.getString());
		return clone;
	}
}
