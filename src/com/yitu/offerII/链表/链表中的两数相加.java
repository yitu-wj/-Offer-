package com.yitu.offerII.链表;

import com.yitu.offerII.ListNode;

/**
 * https://leetcode-cn.com/problems/lMSNwu/
 */
public class 链表中的两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode reversedHead = addReversed(l1, l2);
        return reverseList(reversedHead);
    }

    private ListNode addReversed(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;

            ListNode newNode = new ListNode(sum);

            sumNode.next = newNode;
            sumNode = sumNode.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry > 0) {
            sumNode.next = new ListNode(carry);
        }
        return dummy.next;
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
