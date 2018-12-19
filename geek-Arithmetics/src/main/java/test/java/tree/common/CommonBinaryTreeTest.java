/*
package test.java.tree.common;

import java.util.List;

import org.junit.Test;

import test.java.tree.NodeData;
import test.java.tree.util.TreeUtil;


*/
/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 *//*

public class CommonBinaryTreeTest extends JunitConsole {

	private String[] preOrder = new String[]{"A", "B", "D", "H", "I", "E", "C", "F", "J", "K", "G", "L"};
	private String[] inOrder = new String[]{"H", "D", "I", "B", "E", "A", "J", "F", "K", "C", "L", "G"};
	private String[] postOrder = new String[]{"H", "I", "D", "E", "B", "J", "K", "F", "L", "G", "C", "A"};

	public void show(String tag, List<NodeData> values) {
		StringBuilder sb = new StringBuilder("");
		for(NodeData n : values) {
			CommonTreeNodeData node = (CommonTreeNodeData) n;
			sb.append(node.getString()).append(" ");
		}
		console("{} : {}", tag, sb.toString());
	}
	@Test
	public void testCommon() {

		CommonBinaryTree binaryTree = TreeUtil.createByPreOrderAndInOrder(preOrder, inOrder);
		CommonBinaryTree binaryTree1 = TreeUtil.createByPostOrderAndInOrder(postOrder, inOrder);
		
		show("先序", binaryTree.preorderTraversal());
		show("先序", binaryTree1.preorderTraversal());
		show("中序", binaryTree.inorderTraversal());
		show("中序", binaryTree1.inorderTraversal());
		show("后序", binaryTree.postorderTraversal());
		show("后序", binaryTree1.postorderTraversal());
	}
}
*/
