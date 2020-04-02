package org.tzl.btree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree implements BinaryTree {

    private Node root;
    //private int size;

    public LinkedBinaryTree() {
        super();
    }


    /**
     * 遍历二叉树，必须从root开始
     *
     * @param root
     */
    public LinkedBinaryTree(Node root) {
        super();
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        System.out.println("");
        return this.size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        } else {

            int nl = this.size(root.leftChild);

            int nr = this.size(root.rightChild);

            return nl + nr + 1;
        }
    }

    @Override
    public int getHeight() {
        System.out.println("");
        return this.getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {

            int nl = this.getHeight(root.leftChild);

            int nr = this.getHeight(root.rightChild);

            return nl > nr ? nl + 1 : nr + 1;
        }
    }

    @Override
    public Node findKey(int value) {

        return this.findKey(value, root);
    }

    public Node findKey(Object value, Node root) {

        if (root == null) {
            return null;
        } else if (root != null && root.value == value) {
            return root;
        } else {
            Node node1 = this.findKey(value, root.leftChild);
            Node node2 = this.findKey(value, root.rightChild);
            if (node1 != null && node1.value == value) {
                return node1;
            } else if (node2 != null && node2.value == value) {
                return node2;
            } else {
                return null;
            }
        }

    }

    /**
     * 前根遍历
     */
    @Override
    public void preOrderTraverse() {
        if (root != null) {

            System.out.print(root.value + "  ");


            BinaryTree leftTree = new LinkedBinaryTree(root.leftChild);
            leftTree.preOrderTraverse();


            BinaryTree rightTree = new LinkedBinaryTree(root.rightChild);
            rightTree.preOrderTraverse();
        }

    }

    /**
     * 中根遍历
     */
    @Override
    public void inOrderTraverse() {
        System.out.println("");
        this.inOrderTraverse(root);
        System.out.println();

    }

    private void inOrderTraverse(Node root) {//node7
        if (root != null) {

            this.inOrderTraverse(root.leftChild);//null

            System.out.print(root.value + "  ");//7

            this.inOrderTraverse(root.rightChild);//null
        }
    }

    /**
     * 后根遍历
     */
    @Override
    public void postOrderTraverse() {
        System.out.println("");
        this.postOrderTraverse(root);
        System.out.println();

    }

    @Override
    public void postOrderTraverse(Node node) {
        if (node != null) {

            this.postOrderTraverse(node.leftChild);

            this.postOrderTraverse(node.rightChild);

            System.out.print(node.value + "  ");
        }

    }

    @Override
    public void inOrderByStack() {
        System.out.println("");
        // ����ջ
        Deque<Node> stack = new LinkedList<Node>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.value + " ");
                current = current.rightChild;
            }
        }
        System.out.println();

    }

    @Override
    public void preOrderByStack() {
        // TODO Auto-generated method stub

    }

    @Override
    public void postOrderByStack() {
        // TODO Auto-generated method stub

    }

    /**
     * 广度遍历
     */
    @Override
    public void levelOrderByStack() {
        System.out.println("");
        if (root == null) return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                System.out.print(temp.value + " ");
                if (temp.leftChild != null) queue.add(temp.leftChild);
                if (temp.rightChild != null) queue.add(temp.rightChild);
            }
        }

        System.out.println();

    }

}
