/*
package test.java.tree.bst;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import test.java.tree.NodeData;
import test.java.tree.common.CommonBinaryTreeTest;

*/
/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 *//*

public class BinarySortTreeTest extends CommonBinaryTreeTest {

	private BinarySortTree tree = null;
	@Before
	public void init() {

		tree = new BinarySortTree(new SortTreeNode(new SortTreeNodeData(15)));
		
		int[] values = new int[]{2, 7, 8, 3, 5, 11, 18, 16, 14};
		for(int v : values) {
			tree.insert(new SortTreeNode(new SortTreeNodeData(v)));
		}
	}
	@Override
	public void show(String tag, List<NodeData> values) {
		StringBuilder sb = new StringBuilder("");
		for(NodeData n : values) {
			SortTreeNodeData node = (SortTreeNodeData) n;
			sb.append(node.getValue()).append(" ");
		}
		console("{} : {}", tag, sb.toString());
	}
	@Test
	public void Test() {

		show("inorderTraversal", tree.inorderTraversal());
		
		tree.delete(tree.search(new SortTreeNodeData(8)));
		show("inorderTraversal delete 8", tree.inorderTraversal());

		tree.delete(tree.search(new SortTreeNodeData(14)));
		show("inorderTraversal delete 14", tree.inorderTraversal());
		
		tree.delete(tree.search(new SortTreeNodeData(7)));
		show("inorderTraversal delete 7", tree.inorderTraversal());
	}
}
*/
