package com.leetcode.before;

import java.util.*;

public class BinaryTreeLevel_107 {
    public static void main(String[] args) {

        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node_2, node_3);
        node_2.left = new TreeNode(4);
        node_3.right = new TreeNode(5);

        // queue방식
        levelOrderBottom(root);

        // bfs 재귀 방식
        List<List<Integer>> levelTraversal = new ArrayList<List<Integer>>();
        recursion(root, levelTraversal, 0);
        Collections.reverse(levelTraversal);

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;
        Stack<List<Integer>> stack = new Stack<>();

        bfs(root, stack);

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

static void bfs(TreeNode treeNode, Stack<List<Integer>> stack) {

    Queue<List<TreeNode>> queue = new LinkedList<>();
    queue.add(List.of(treeNode));
    stack.push(List.of(treeNode.val));

    while (!queue.isEmpty()) {
        List<TreeNode> poll = queue.poll();
        List<TreeNode> queueList = new ArrayList<>();
        List<Integer> stackList = new ArrayList<>();

        for (TreeNode node : poll) {
            if (node.left != null) {
                queueList.add(node.left);
                stackList.add(node.left.val);
            }
            if (node.right != null) {
                queueList.add(node.right);
                stackList.add(node.right.val);
            }
        }

        if (!queueList.isEmpty()) queue.add(queueList);
        if (!stackList.isEmpty()) stack.push(stackList);
    }
}


private static void recursion(TreeNode root, List<List<Integer>> levelTraversal, int level) {
    if(root == null) {
        return;
    }
    while(levelTraversal.size() <= level) {
        levelTraversal.add(new ArrayList<>());
    }
    levelTraversal.get(level).add(root.val);
    recursion(root.left, levelTraversal, level+1);
    recursion(root.right, levelTraversal, level+1);
}

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
