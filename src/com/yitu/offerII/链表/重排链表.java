package com.yitu.offerII.链表;

import com.yitu.offerII.ListNode;

/**
 * https://leetcode-cn.com/problems/LGjMqU/
 */
public class 重排链表 {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        ListNode temp = slow.next;
        slow.next = null;
        link(head, reverseList(temp), dummy);
    }

    private void link(ListNode node1, ListNode node2, ListNode head) {
        ListNode prev = head;
        while (node1 != null && node2 != null) {
            ListNode temp = node1.next;

            prev.next = node1;
            node1.next = node2;
            prev = node2;

            node1 = temp;
            node2 = node2.next;
        }

        if (node1 != null) {
            prev.next = node1;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
