package com.xhx.java;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {

    /**
     * 二叉树构建 把链表转换成非线性二叉树
     * @param inputList
     * @return
     */
    public static  TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if(inputList == null || inputList.isEmpty()){
            return null;
        }

        Integer data = inputList.removeFirst();
        if(data != null){
            node = new TreeNode(data);
            node.setLeftChild(createBinaryTree(inputList));
            node.setRightChild(createBinaryTree(inputList));
        }
        return node;
    }
    //链表节点的顺序恰恰是二叉树前序遍历的顺序。
    // 链表中的空值，代表二叉树节点的左孩子或右孩子为空的情况。
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays
                .asList(1, 2, 4, null, null, 5, null,null, 3, null, 6));
        TreeNode treeNode = BinaryTree.createBinaryTree(list);
        System.out.println(treeNode);
    }
}
