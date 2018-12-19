package test.java.tree;
/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 */
public abstract class AbstractTreeNode {

	public abstract AbstractTreeNode getLeftChild();
	public abstract AbstractTreeNode getRightChild();
	public abstract AbstractTreeNode getParent();
	
	public abstract NodeData cloneData();

	public abstract void setLeftChild(AbstractTreeNode node);
	public abstract void setRightChild(AbstractTreeNode node);
	public abstract void setParent(AbstractTreeNode node);
}
