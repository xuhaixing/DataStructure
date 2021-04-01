package com.xhx.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证一棵树是二叉搜索树
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class LC98 {

    @Test
    public void test01(){

        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
//        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
//        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> list = new ArrayList<>();
        preLoop(root, list);
        if(list.isEmpty() || list.size() == 1){
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).val >= list.get(i+1).val){
                return false;
            }
        }
        return true;
    }

    private void preLoop(TreeNode root, List<TreeNode> list) {
        if(root == null){
            return;
        }
        preLoop(root.left, list);
        list.add(root);
        preLoop(root.right, list);
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
    }

}
