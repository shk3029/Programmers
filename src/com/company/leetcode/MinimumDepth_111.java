package com.company.leetcode;

import java.util.*;

public class MinimumDepth_111 {
    public static void main(String[] args) {

/*
        TreeNode root = new TreeNode(2);
        TreeNode node_1 = new TreeNode(3);
        TreeNode node_2 = new TreeNode(4);
        TreeNode node_3 = new TreeNode(5);
        TreeNode node_4 = new TreeNode(6);

        root.right = node_1;
        node_1.right = node_2;
        node_2.right = node_3;
        node_3.right = node_4;
*/



        TreeNode root = new TreeNode(1);
        TreeNode node_1 = new TreeNode(2);
        TreeNode node_2 = new TreeNode(3);
        TreeNode node_3 = new TreeNode(4);
        TreeNode node_4 = new TreeNode(5);

        root.left = node_1;
        root.right = node_2;

        node_1.left = node_3;
        node_1.right = node_4;

        System.out.println(root);
        minDepth(root);
    }

    public static int minDepth(TreeNode root) {
        return bfs(root);
    }

    private static int bfs(TreeNode root) {
        if (root == null) return 0;
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<List<TreeNode>> result = new ArrayList<>();
        queue.add(List.of(root));

        boolean isSearch = false;

        while (!queue.isEmpty() && !isSearch) {
            List<TreeNode> list = new ArrayList<>();
            List<TreeNode> pop = queue.poll();
            list.addAll(pop);

            List<TreeNode> queueList = new ArrayList<>();

            for (TreeNode node : pop) {
                if (node.left == null && node.right == null) {
                    isSearch = true;
                    break;
                }

                if (node.left != null) queueList.add(node.left);
                if (node.right != null) queueList.add(node.right);
            }

            if (!queueList.isEmpty()) queue.add(queueList);
            if (!list.isEmpty()) result.add(list);
        }

        return result.size();
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
            return "val : " + val;
        }
    }
}
