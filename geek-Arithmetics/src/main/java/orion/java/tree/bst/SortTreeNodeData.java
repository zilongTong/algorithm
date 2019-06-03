package orion.java.tree.bst;

import orion.java.tree.INodeData;
import orion.java.tree.common.CommonTreeNodeData;

/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 */
public class SortTreeNodeData extends CommonTreeNodeData {

	private int value;
	
	public SortTreeNodeData(int value) {
		super();
		this.value = value;
	}
	@Override
	public int getValue() {
		return value;
	}
	@Override
	public boolean greaterThan(INodeData v) {
		return value > v.getValue();
	}
	@Override
	public boolean lessThan(INodeData v) {
		return value < v.getValue();
	}
	@Override
	public boolean equal(INodeData v) {
		return value == v.getValue();
	}
}
