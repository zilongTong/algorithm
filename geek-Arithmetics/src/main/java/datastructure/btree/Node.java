package datastructure.btree;

/**
 * 二叉链表的结点
 *
 * @author Administrator
 */
public class Node {
    /**
     * 结点值
     */
    Object value;
    /**
     * 左子树的引用
     */
    Node leftChild;
    /**
     * 右子树的引用
     */
    Node rightChild;


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