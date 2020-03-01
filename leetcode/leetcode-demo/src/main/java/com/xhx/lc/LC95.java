package com.xhx.lc;

import java.util.ArrayList;
import java.util.List;

public class LC95 {

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new LC95().generateTrees(3);

    }

    public List<TreeNode> generateTrees(int n) {
        if(n<1){
            return new ArrayList<>();
        }
        List<TreeNode> trees = createTrees(1, n);
        return trees;
    }
    private List<TreeNode> createTrees(int start, int end){
        List<TreeNode> root = new ArrayList<>();
        if(start > end){
            root.add(null);
            return root;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftTrees = createTrees(start, i - 1);
            List<TreeNode> rightTrees = createTrees(i+1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree;
                    node.right = rightTree;
                    root.add(node);
                }
            }
        }
        return root;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}