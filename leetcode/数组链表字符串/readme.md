# 数组、链表

数组链表代表着计算机最基本的两种存储形式：顺序存储和链式存储，所以他俩可以算是最基本的数据结构。

 数组链表的主要算法技巧是**双指针**，双指针⼜分为中间向两端扩散的双指针、两端向中间收缩的双指针、快 慢指针。 

此外，数组还有**前缀和**和**差分数组**，也属于必知必会的算法技巧。



## 前缀和

前缀和主要适⽤的场景是原始数组不会被修改的情况下，频繁查询某个区间的累加和。

核心代码：

```java
class PrefixSum {
 // 前缀和数组
 private int[] prefix;
 
 /* 输⼊⼀个数组，构造前缀和 */
 public PrefixSum(int[] nums) {
   prefix = new int[nums.length + 1];
   // 计算 nums 的累加和
   for (int i = 1; i < prefix.length; i++) {
   	prefix[i] = prefix[i - 1] + nums[i - 1];
   }
 }
 /* 查询闭区间 [i, j] 的累加和 */
 public int query(int i, int j) {
 	return prefix[j + 1] - prefix[i];
 }
}
```



## 差分数组

差分数组的主要适⽤场景是频繁对原始数组的 某个区间的元素进⾏增减。

⽐如说，我给你输⼊⼀个数组 nums，然后⼜要求给区间 nums[2..6] 全部加 1，再给 nums[3..9] 全部减 3，再给 nums[0..4] 全部加 2 等。

常规的思路很容易，你让我给区间 nums[i..j] 加上 val，那我就⼀个 for 循环给它们都加上，这种思路的时间复杂度是 O(N)，由于这个场景下对 nums 的修改⾮常频繁，所以效率会很低下。

这⾥就需要差分数组的技巧，类似前缀和技巧构造的 prefix 数组，我们先对 nums 数组构造⼀个 diff 差 分数组，diff[i] 就是 nums[i] 和 nums[i-1] 之差：

```java
int[] diff = new int[nums.length];
// 构造差分数组
diff[0] = nums[0];
for (int i = 1; i < nums.length; i++) {
 	diff[i] = nums[i] - nums[i - 1];
}
```

通过这个 diff 差分数组是可以反推出原始数组 nums 的，代码逻辑如下：

```java
int[] res = new int[diff.length];
// 根据差分数组构造结果数组
res[0] = diff[0];
for (int i = 1; i < diff.length; i++) {
 	res[i] = res[i - 1] + diff[i];
}
```

这样构造差分数组 diff，就可以快速进⾏区间增减的操作，如果你想对区间 nums[i..j] 的元素全部加 3，那么只需要让 diff[i] += 3，然后再让 diff[j+1] -= 3 即可。只要花费 O(1) 的时间修改 diff 数组，就相当于给 nums 的整个区间做了修改。多次修改 diff，然后通过 diff 数组反推，即可得到 nums 修改后的结果。

把差分数组抽象成⼀个类，包含 increment ⽅法和 result ⽅法：

```java
// 差分数组⼯具类
class Difference {
 // 差分数组
 private int[] diff;
 
 /* 输⼊⼀个初始数组，区间操作将在这个数组上进⾏ */
 public Difference(int[] nums) {
     assert nums.length > 0;
     diff = new int[nums.length];
     // 根据初始数组构造差分数组
     diff[0] = nums[0];
     for (int i = 1; i < nums.length; i++) {
        diff[i] = nums[i] - nums[i - 1];
     }
 }
  
 /* 给闭区间 [i,j] 增加 val（可以是负数）*/
 public void increment(int i, int j, int val) {
     diff[i] += val;
     if (j + 1 < diff.length) {
        diff[j + 1] -= val;
     }
 }
  
 /* 返回结果数组 */
 public int[] result() {
     int[] res = new int[diff.length];
     // 根据差分数组构造结果数组
     res[0] = diff[0];
     for (int i = 1; i < diff.length; i++) {
      	res[i] = res[i - 1] + diff[i];
     }
     return res;
 }
}

```



## 双指针

快慢指针、左右指针

### 滑动窗口

这个算法技巧思路非常简单，就是维护一个窗口，不断滑动，然后更新答案。大致框架如下：

```java
int left = 0, right = 0;
while (right < s.length) {
  //增大窗口
  window.add(s[right]);
  right++;
  
  //进行某些数据更新
  //...
  
  //窗口是否满足收缩条件
  while(window need shrink) {
    //缩小窗口
    window.remove(s[left]);
    left++;
    //进行某些数据更新
  	//...
  }
}
```

困扰大家的不是算法的思路，而是各种细节问题。比如何时向窗口中添加元素，何时缩小窗口，在滑动窗口的哪个阶段更新结果。

应用模板，需要考虑以下四个问题：

1. 当移动right扩大窗口时，即加入字符时，应该更新哪些数据
2. 什么条件下，窗口应该暂停扩大，开始移动left缩小窗口
3. 当移动left缩小窗口，即移出字符时，应该更新哪些数据
4. 我们要的结果应该在扩大窗口时还是缩小窗口时进行更新

### 二分法



### 去重

我们知道对于数组来说，在尾部插⼊、删除元素是⽐较⾼效的，时间复杂度是 O(1)，但是如果在中间或者开头插⼊、删除元素，就会涉及数据的搬移，时间复杂度为 O(N)，效率较低。

1. 把要删除的元素交换到最后一个
2. 原地修改数组，避免数据搬移

通常的解法就是应用双指针中的`快慢指针`技巧。

