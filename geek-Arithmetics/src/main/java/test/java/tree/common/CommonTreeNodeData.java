package test.java.tree.common;

import test.java.tree.NodeData;

/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 */
public class CommonTreeNodeData extends NodeData {

	private String string;
	
	public CommonTreeNodeData() {
		
	}
	
	public CommonTreeNodeData(String string) {
		super();
		this.string = string;
	}

	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	
}
