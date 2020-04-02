package org.tzl.btree;

/**
 * @author Administrator
 */
public interface BinaryTree {
    /**
     * @return
     */
    public boolean isEmpty();

    /**
     * @return
     */
    public int size();

    /**
     * @return
     */
    public int getHeight();

    /**
     * @param value
     * @return
     */
    public Node findKey(int value); // ????

    /**
     *
     */
    public void preOrderTraverse();

    /**
     *
     */
    public void inOrderTraverse();

    /**
     *
     */
    public void postOrderTraverse();

    /**
     *
     */
    public void postOrderTraverse(Node node);

    /**
     *
     */
    public void inOrderByStack();


    public void preOrderByStack();

    /**
     *
     */
    public void postOrderByStack();

    /**
     *
     */
    public void levelOrderByStack();
}


