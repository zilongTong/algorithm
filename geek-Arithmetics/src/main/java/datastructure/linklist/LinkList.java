/*
 * Copyright (C),2016-2018. 上海朔羡网络科技有限公司
 * FileName: LinkList.java
 * Author:  tongzilong@mgzf.com
 * Date:     2018-09-20 10 : 28:00
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述
 * <tongzilong>  <2018-09-20 10 : 28:00> <version>   <desc>
 */

package datastructure.linklist;

import java.util.LinkedList;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:tongzilong@mgzf.com
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LinkList<E> {

    //    LinkedList
    Node<E> head = null;
    Node<E> tail = null;


    public void createNode() {
        head = new Node("leo");
        tail = head;
    }

    public void addNode() {
        tail.next = new Node("ton");
        tail = tail.next;
    }

    void printListRev(Node<String> head) {
        //倒序遍历链表主要用了递归的思想
        if (head != null) {
            printListRev(head.next);
            System.out.println(head.item);
        }
    }

    public void ItNode() {
        Node current = head;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }

    }

    //单链表反转 主要是逐一改变两个节点间的链接关系来完成
    Node<String> revList(Node<String> head) {

        if (head == null) {
            return null;
        }

        Node<String> nodeResult = null;

        Node<String> nodePre = null;
        Node<String> current = head;

        while (current != null) {

            Node<String> nodeNext = current.next;

            if (nodeNext == null) {
                nodeResult = current;
            }

            current.next = nodePre;
            nodePre = current;
            current = nodeNext;
        }

        return nodeResult;
    }

    class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
            this.next = null;
        }
    }

}
