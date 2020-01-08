package com.xhx.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 递归 同Test01，只是输入数据不一样
 * 前序遍历
 * 中序遍历
 * 后序遍历
 *
 *                   1
 *            2              3
 *       4        5               6
 *              7   8
 */
public class Test02 {


    @Test
    public void test01() {
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays
                .asList(1, 2, 4, null, null, 5, 7,null,null, 8, null, null, 3, null, 6));
        TreeNode treeNode = BinaryTree.createBinaryTree(list);

        preOrderTraveral(treeNode);
        System.out.println();

        inOrderTraveral(treeNode);
        System.out.println();

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
