package com.company.study.section.section2;


import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode l1_node_1 = new ListNode(9);
        ListNode l1_node_2 = new ListNode(9,l1_node_1);
        ListNode l1_node_3 = new ListNode(9,l1_node_2);
        ListNode l1_node_4 = new ListNode(9,l1_node_3);
        ListNode l1_node_5 = new ListNode(9,l1_node_4);
        ListNode l1_node_6 = new ListNode(9,l1_node_5);

        ListNode l2_node_1 = new ListNode(9);
        ListNode l2_node_2 = new ListNode(9,l2_node_1);
        ListNode l2_node_3 = new ListNode(9,l2_node_2);

        ListNode l1 = new ListNode(9,l1_node_6);
        ListNode l2 = new ListNode(9,l2_node_3);

        addTwoNumbers(l1, l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> result = new ArrayList<>();
        boolean isOver = false;

        while (l1 != null || l2 != null || isOver) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum = isOver ? value1 + value2 + 1 : value1 + value2;

            if (sum >= 10) {
                isOver = true;
                sum -= 10;
            } else {
                isOver = false;
            }

            result.add(sum);
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        ListNode listNode = new ListNode(result.get(0));
        ListNode curNode = listNode;
        for (int i=1; i<result.size(); i++) {
            ListNode node = new ListNode(result.get(i));
            curNode.next = node;
            curNode = curNode.next;
        }

        return listNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
