package test.java.tree.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.java.tree.common.CommonBinaryTree;
import test.java.tree.common.CommonTreeNode;
import test.java.tree.common.CommonTreeNodeData;

/**
 *
 * @author Smile.Wu
 * @version 2015-11-18
 */
public class TreeUtil {

	public static CommonBinaryTree createByPreOrderAndInOrder(String[] preorderArray, String[] inorderArray) {
		return new CommonBinaryTree(getNodeByPreAndInOrder(preorderArray, inorderArray));
	}
	public static CommonBinaryTree createByPostOrderAndInOrder(String[] preorderArray, String[] inorderArray) {
		return new CommonBinaryTree(getNodeByPostAndInOrder(preorderArray, inorderArray));
	}
	
	public static CommonTreeNode getNodeByPreAndInOrder(String[] preorderArray, String[] inorderArray) {
		CommonTreeNode current = null;
		if(preorderArray.length > 0) {
			String rootChar = preorderArray[0];
			current = new CommonTreeNode(new CommonTreeNodeData(rootChar));
			SubListContainer container = new SubListContainer(rootChar, preorderArray, inorderArray);
			
			current.setLeftChild(getNodeByPreAndInOrder(container.getLeft1(), container.getRight1()));
			current.setRightChild(getNodeByPreAndInOrder(container.getLeft2(), container.getRight2()));
		}
		return current;
	}
	
	

	public static CommonTreeNode getNodeByPostAndInOrder(String[] postorderArray, String[] inorderArray) {
		CommonTreeNode current = null;
		if(postorderArray.length > 0) {
			String rootChar = postorderArray[postorderArray.length - 1];
			current = new CommonTreeNode(new CommonTreeNodeData(rootChar));
			
			SubListContainer container = new SubListContainer(rootChar, postorderArray, inorderArray);
			
			current.setLeftChild(getNodeByPostAndInOrder(container.getLeft1(), container.getRight1()));
			current.setRightChild(getNodeByPostAndInOrder(container.getLeft2(), container.getRight2()));
		}
		return current;
	}
	
	static class SubListContainer {
		private String[] left1;
		private String[] right1;
		private String[] left2;
		private String[] right2;
		public SubListContainer(String rootChar, String[] leftArray, String[] rightArray) {
			List<String> leftPreorder = new ArrayList<>();
			List<String> leftInorder = new ArrayList<>();
			List<String> rightPreorder = new ArrayList<>();
			List<String> rightInorder = new ArrayList<>();
			
			Map<String, Integer> map = new HashMap<String, Integer>(rightArray.length);
			int c = 0;
			boolean isLeft = true;
			for(String s : rightArray) {
				map.put(s, c ++);
				if(s.equals(rootChar)) {
					isLeft = false;
				} else {
					if(isLeft) {
						leftInorder.add(s);
					} else {
						rightInorder.add(s);
					}
				}
			}
			
			int rootIndex = map.get(rootChar);
			for(String p : leftArray) {
				int pValue = map.get(p);
				if(pValue > rootIndex) {//右子树
					rightPreorder.add(p);
				} else if(pValue < rootIndex) {//左子树
					leftPreorder.add(p);
				}
			}
			
			left1 = leftPreorder.toArray(new String[]{});
			right1 = leftInorder.toArray(new String[]{});
			left2 = rightPreorder.toArray(new String[]{});
			right2 = rightInorder.toArray(new String[]{});
			
		}
		public String[] getLeft1() {
			return left1;
		}
		public String[] getRight1() {
			return right1;
		}
		public String[] getLeft2() {
			return left2;
		}
		public String[] getRight2() {
			return right2;
		}
	}

}
