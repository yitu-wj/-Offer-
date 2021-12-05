package com.yitu.offerII.链表;

import com.yitu.offerII.ListNode;

/**
 * https://leetcode-cn.com/problems/SLwz0R/
 */
public class 删除链表的倒数第n个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode front = head, back = dummy;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;

        return dummy.next;
    }
}
