package test.java.tree;
/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 */
public abstract class NodeData implements INodeData {

	@Override
	public int getValue() {
		return 0;
	}
	@Override
	public boolean greaterThan(INodeData v) {
		return false;
	}
	@Override
	public boolean lessThan(INodeData v) {
		return false;
	}
	@Override
	public boolean equal(INodeData v) {
		return false;
	}
}

