package test.java.tree;


/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 */
public interface INodeData {
	
	public int getValue();
	public boolean equal(INodeData v);
	public boolean greaterThan(INodeData v);
	public boolean lessThan(INodeData v);
}
