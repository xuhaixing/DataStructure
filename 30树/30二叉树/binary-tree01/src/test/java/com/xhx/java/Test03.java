package com.xhx.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 非递归方式
 */
public class Test03 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays
                .asList(1, 2, 4, null, null, 5, null,null, 3, null, 6));
        TreeNode treeNode = BinaryTree.createBinaryTree(list);
        preOrderTraveralWithStack(treeNode);
        System.out.println();
        inOrderTraveralWithStack(treeNode);
        System.out.println();

        levelOrderTraversal(treeNode);
    }

    //二叉树非递归前序遍历
    public static void preOrderTraveralWithStack(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            //迭代访问左子树，并入栈
            while (node != null){
                System.out.print(node.getData()+" ");
                stack.push(node);
                node = node.getLeftChild();
            }
            //如果没有左孩子，则弹出栈顶结点，访问节点右孩子
            if(!stack.isEmpty()){
                node = stack.poll();
                node = node.getRightChild();
            }
        }
    }

    //二叉树非递归中序遍历
    public static void inOrderTraveralWithStack(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            //迭代访问左子树，并入栈
            while (node != null){
                stack.push(node);
                node = node.getLeftChild();
            }
            //如果没有左孩子，则弹出栈顶结点，访问节点右孩子
            if(!stack.isEmpty()){
                node = stack.poll();
                System.out.print(node.getData()+" ");
                node = node.getRightChild();
            }
        }
    }

    //二叉树层序遍历
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.getData()+" ");
            if(node.getLeftChild() != null){
                queue.offer(node.getLeftChild());
            }
            if(node.getRightChild() != null){
                queue.offer(node.getRightChild());
            }
        }
    }

}
