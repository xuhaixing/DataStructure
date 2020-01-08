package com.xhx.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 递归
 * 前序遍历
 * 中序遍历
 * 后序遍历
 *
 *                1
 *         2              3
 *    4        5               6
 */
public class Test01 {


    @Test
    public void test01() {
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays
                .asList(1, 2, 4, null, null, 5, null,null, 3, null, 6));
        TreeNode treeNode = BinaryTree.createBinaryTree(list);
        //1 2 4 5 3 6
        preOrderTraveral(treeNode);
        System.out.println();

        //4 2 5 1 3 6
        inOrderTraveral(treeNode);
        System.out.println();

        //4 5 2 6 3 1
        postOrderTraveral(treeNode);
    }
    //根节点、左子树、右子树
    public static  void preOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.getData() + " ");
        preOrderTraveral(node.getLeftChild());
        preOrderTraveral(node.getRightChild());
    }

    //左子树、根节点、右子树
    public static  void inOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraveral(node.getLeftChild());
        System.out.print(node.getData() + " ");
        inOrderTraveral(node.getRightChild());
    }

    //左子树、右子树、根节点
    public static  void postOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraveral(node.getLeftChild());
        postOrderTraveral(node.getRightChild());
        System.out.print(node.getData() + " ");
    }
}
