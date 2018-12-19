package org.tzl.lintcode;

import sort.lucene.DataSet;

/**
 * Created by zilong on 2017/7/25.
 */
public class AddLinkLists {

    public LinkNode addLists(LinkNode l1, LinkNode l2) {
        // write your code here

        return null;
    }




    /**
     * 单向链表
     */
    private static class LinkNode<E> {
        E item;
        LinkNode<E> next;

        LinkNode( E element, LinkNode<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    /**
     * 双向链表
     */
    private static class ListNode<E> {
        E item;
        ListNode<E> pre;
        ListNode<E> next;

        ListNode(ListNode<E> pre, E element, ListNode<E> next) {
            this.item = element;
            this.pre = pre;
            this.next = next;
        }
    }
}
