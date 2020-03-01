# Unique Binary Search Trees II

给定一个整数n，生成所有二叉搜索树，值为1-n

```
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```


分治法

左子树永远比根节点小，右子树永远比根节点大

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
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
```

