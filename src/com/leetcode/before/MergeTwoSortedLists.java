package com.leetcode.before;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        System.out.println(">>>");
        ListNode node1 = new ListNode(-9);
        ListNode node2 = new ListNode(3);

        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;

        node3.next = node4;

        mergeTwoLists(node1, node3);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode curNode;
        curNode = result;

        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                if (l1 == null) {
                    curNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else if (l2 == null) {
                    curNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                curNode = curNode.next;
                continue;
            }

            if (l1.val <= l2.val) {
                curNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
