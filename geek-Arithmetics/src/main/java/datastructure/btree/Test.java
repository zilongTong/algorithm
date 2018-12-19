package datastructure.btree;

public class Test {

    public static void main(String[] args) {
        //创建一个二叉树
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, null, node5);

        Node node3 = new Node(3, null, null);
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, null, node7);

        Node node2 = new Node(2, node3, node6);

        Node node1 = new Node(1, node4, node2);

        BinaryTree btree = new LinkedBinaryTree(node1);
        //BinaryTree  btree = new LinkedBinaryTree();

        //判断二叉树是否为空
        System.out.println(btree.isEmpty());

        //先序遍历递归  1  4  5  2  3  6  7
        System.out.println("先序遍历");
        btree.preOrderTraverse();
        System.out.println();

        //中序遍历递归  4  5  1  3  2  6  7
        btree.inOrderTraverse();

        //后序遍历递归  5  4  3  7  6  2  1
        btree.postOrderTraverse();


        //中序遍历非递归（借助栈） 4  5  1  3  2  6  7
        btree.inOrderByStack();

        //按照层次遍历（借助队列）  1  4  2  5  3  6  7
        btree.levelOrderByStack();


        //在二叉树中查找某个值
        System.out.println(btree.findKey(1));

        //二叉树的高度
        System.out.println(btree.getHeight());

        //二叉树的结点数量
        System.out.println(btree.size());

    }

}