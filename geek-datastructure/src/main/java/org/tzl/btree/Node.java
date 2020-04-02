package org.tzl.btree;

/**
 * 二叉树链式存储
 *
 * @author Administrator
 */
public class Node {

    Object value;
    Node leftChild;
    Node rightChild;

//    Node parent;


    public Node(Object value) {
        super();
        this.value = value;
    }

    public Node(Object value, Node leftChild, Node rightChild) {
        super();
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + ", leftChild=" + leftChild
                + ", rightChild=" + rightChild + "]";
    }
}
