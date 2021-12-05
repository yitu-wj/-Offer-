package com.yitu.offerII.链表;

import com.yitu.offerII.ListNode;

/**
 * https://leetcode-cn.com/problems/c32eOV/
 */
public class 链表中环的入口节点 {
    public ListNode detectCycle1(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }

        int loopCount = 1;
        for (ListNode n = inLoop; n.next != inLoop; n = n.next) {
            loopCount++;
        }

        ListNode fast = head;
        for (int i = 0; i < loopCount; i++) {
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }

        ListNode node = head;
        while (node != inLoop) {
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
    }

    private ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }
}
