# DataStructure
从整体到细节，自顶向下，从抽象到具体的思维框架是通用的，不只是学习数据结构和算法，学习其他任何知识都是高效的。

要学习数据结构和算法的框架思维，要有框架思维，学会提炼重点，一个算法技巧可以包装出一百道题，如果能一眼看穿它的本质，那就没必要浪费时间刷题了。



数据结构与算法

1. 数据结构是工具，算法是通过合适的工具解决特定问题的方法，学习算法，需要了解常用的数据结构，了解它们的特性和缺陷。
2. 数据结构的存储方式只有两种：数组（顺序存储）和链表（链式存储）
3. 对于任何数据结构，其基本操作无非遍历 + 访问，再具体一点就是：增删查改。遍历：**循环+递归**
3. 数据结构种类众多，但他们存在的目的都是在不同的应用场景，尽可能高效地增删改查。



**只有简单的例子才能让你把精力充分集中在算法背后的通用思想和技巧上，而不会被那些隐晦的细节问题搞的莫名其妙**



各种数据结构的 遍历+访问 无非两种形式：**线性的**和**非线性的**，线性的就是for/while迭代为代表，非线性就是递归迭代为代表。无非以下两种框架：

数组遍历框架，典型的线性迭代结构：

```java
void traverse(int[] arr) {
   for (int i = 0; i < arr.length; i++) {
   		// 迭代访问 arr[i]
   }
}

```

链表遍历框架，兼具迭代和递归结构：

```java
/* 基本的单链表节点 */
class ListNode {
   int val;
   ListNode next;
}
//迭代
void traverse(ListNode head) {
   for (ListNode p = head; p != null; p = p.next) {
   		// 迭代访问 p.val
   }
}
//递归
void traverse(ListNode head) {
   // 递归访问 head.val
   traverse(head.next);
}
```



二叉树的遍历，典型的非线性递归遍历结构：

```java
/* 基本的⼆叉树节点 */
class TreeNode {
   int val;
   TreeNode left, right;
}
void traverse(TreeNode root) {
  //前序遍历
   traverse(root.left);
  //中序遍历
   traverse(root.right);
  //后序遍历
}
```



二叉树遍历可以扩展为N叉树遍历：

```java
/* 基本的 N 叉树节点 */
class TreeNode {
   int val;
   TreeNode[] children;
}
void traverse(TreeNode root) {
   for (TreeNode child : root.children){
   		traverse(child);
   }
}

```

N叉树遍历又可以扩展为图的遍历，因为图是好几个N叉树的结合体，图可能出现环，用个visited做标记就可以了。



算法的本质就是「穷举」，穷举具体来说可以分为两点：

1. 如何穷举
2. 如何聪明的穷举

不同类型的题目，难点是不同的，有的题目难在 如何穷举，有的题目难在 如何聪明的穷举。

什么算法的难点在 如何穷举 呢？一般是递归类问题，最典型的就是动态规划系列问题

什么算法的难点在 如何聪明的穷举 呢？一些分递归算法技巧。



## 数组、单链表系列算法

双指针



## 二叉树系列算法

二叉树题目的递归解法可以分为两类，第一类是遍历一遍二叉树得出答案，第二类是通过分解计算出答案，这两类思路分别对应着 **回溯算法核心框架** 和 **动态规划核心框架**。

比如：二叉树最大深度问题

遍历一遍得出答案

```java
// 记录最⼤深度
int res = 0;
int depth = 0;
// 主函数
int maxDepth(TreeNode root) {
  traverse(root);
  return res;
}
// ⼆叉树遍历框架
void traverse(TreeNode root) {
  if (root == null) {
    // 到达叶⼦节点
    res = Math.max(res, depth);
  	return;
	}
  // 前序遍历位置
  depth++;
  traverse(root.left);
  traverse(root.right);
  // 后序遍历位置
  depth--;
}
```

通过分解问题得到答案

```java
// 定义：输⼊根节点，返回这棵⼆叉树的最⼤深度
int maxDepth(TreeNode root) {
  if (root == null) {
  	return 0;
  }
  // 递归计算左右⼦树的最⼤深度
  int leftMax = maxDepth(root.left);
  int rightMax = maxDepth(root.right);
  // 整棵树的最⼤深度
  int res = Math.max(leftMax, rightMax) + 1;
  return res;
}

```

动态规划系列问题有「最优⼦结构」和「重叠⼦问题」两个特性，⽽且⼤多是让你求最值的。很多算法虽然不属于动态规划，但也符合分解问题的思维模式。比如分治算法中，如果没有重叠子问题，就不用去用备忘录做优化了。



