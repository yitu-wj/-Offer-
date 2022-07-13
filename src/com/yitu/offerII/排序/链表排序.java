package com.yitu.offerII.排序;

import com.yitu.offerII.ListNode;

/**
 * https://leetcode.cn/problems/7WHec2/
 */
public class 链表排序 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode head1 = head;
        ListNode head2 = split(head);

        head1 = sortList(head1);
        head2 = sortList(head2);

        return merge(head1, head2);
    }

    private ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        return second;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }
}
