package com.yitu.offerII.链表;

/**
 * https://leetcode-cn.com/problems/Qv1Da2/
 */
public class 展平多级双向链表 {
    public Node flatten(Node head) {
        flattenGatTail(head);
        return head;
    }

    private Node flattenGatTail(Node head) {
        Node node = head;
        Node tail = null;
        while (node != null) {
            Node next = node.next;
            if (node.child != null) {
                Node child = node.child;
                Node childTail = flattenGatTail(node.child);

                node.child = null;
                node.next = child;
                child.prev = node;
                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }
                tail = childTail;
            } else {
                tail = node;
            }
            node = next;
        }
        return tail;
    }
    public class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
