# 二分法

二分搜索的原型就是在**有序数组**中搜索一个target，返回该元素对应的索引，如果该元素不存在，那就返回一个特殊值，这种细节问题只要微调算法实现就能实现。

如果**有序数组**中存在多个 target元素，那么这些元素肯定挨在一起，这里就涉及到算法应该返回最左侧的那个target元素的索引还是最右侧的那个target元素的索引，也就是所谓的 「搜索左侧边界」和「搜索右侧边界」，这个也可以通过微调算法的代码来实现。

算法题一般是让求最值，求最值的过程，必然是一个搜索边界的过程。



## **二分查找框架**

```java
int binarySearch(int[] nums, int target) {
   int left = 0, right = ...;
   while(...) {
       int mid = left + (right - left) / 2;
       if (nums[mid] == target) {
          ...
       } else if (nums[mid] < target) {
          left = ...
       } else if (nums[mid] > target) {
          right = ...
       }
   }
   return ...;
}

```

尽量不要出现else，而是把所有情况用else if写清楚，这样可以清楚的展现所有细节。

计算mid时 `int mid = left + (right - left) / 2;`可以防止`(right+left)/2`溢出。

### 寻找一个数

```java
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
```

1. 为什么while循环中条件是<=而不是<?

   若循环条件是<=，则搜索区间是`[left, right]`，若循环条件是<，则搜索区间是`[left, right)`， 因为right初始赋值为`nums.length-1`，所以为<=。

2. 什么时候停止循环

   1. 找到目标值`nums[mid] == target`
   2. 循环条件不满足时。若是<=，终止条件是left=right+1，若是<，终止条件是left=right。

3. 为什么`left = mid + 1`，`right = mid - 1`，有的代码是`right = mid`或者`right = mid`

   right与left的赋值与搜索区间和具体场景求值有关系。本题中 mid已经与target对比过了，所以下次搜索区间就不需要考虑mid索引的元素。

如给你有序数组 nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 2，没错。但是如果我想得到 target 的左侧边界，即索引 1，或者我想得到 target 的右侧边界，即索引 3，这样的话此算法是⽆法处理的。



### 搜索左边界

```java
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 当找到 target 时，收缩右侧边界
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return num[left] == target?left:-1;
    }

```

1. 为什么while循环条件是<

   因为right 初始赋值为 nums.length，不需要包含右区间，若包含就越界了。

2. 为什么right=mid，和上面不一样

   因为while循环用的 <，不包括右区间。

3. 为什么该算法能够搜索左侧边界

   当找到target时，缩小搜索区间的上界

   ```java
   if (nums[mid] == target) {
     right = mid;
   }
   ```

4. 返回的为什么是left而不是right，也不需要-1或+1

   返回时，right=left，而收缩区间时right=mid，所以只返回left就可。

5. 可否把right变成nums.length-1

   可以，但要注意过度条件

   ```java
       int left_bound(int[] nums, int target) {
           int left = 0, right = nums.length - 1;
           // 搜索区间为 [left, right]
           while (left <= right) {
               int mid = left + (right - left) / 2;
               if (nums[mid] < target) {
                   // 搜索区间变为 [mid+1, right]
                   left = mid + 1;
               } else if (nums[mid] > target) {
                   // 搜索区间变为 [left, mid-1]
                   right = mid - 1;
               } else if (nums[mid] == target) {
                   // 收缩右侧边界
                   right = mid - 1;
               }
           }
           // 检查出界情况
           if (left >= nums.length || nums[left] != target)
               return -1;
           return left;
       }
   ```



### 搜索右边界

类似搜索左边界，也有两种写法，左闭右开与左右都是闭区间

```java
    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return  nums[left-1] == target ? (left-1) : -1; // 注意
    }
```

1. 为什么最后返回left-1

   因为满足条件时，left = mid + 1，所以退出循环时，left多加了个1。

2. 闭区间代码

   ```java
       int right_bound(int[] nums, int target) {
           int left = 0, right = nums.length - 1;
           while (left <= right) {
               int mid = left + (right - left) / 2;
               if (nums[mid] < target) {
                   left = mid + 1;
               } else if (nums[mid] > target) {
                   right = mid - 1;
               } else if (nums[mid] == target) {
                   // 这⾥改成收缩左侧边界即可
                   left = mid + 1;
               }
           }
           // 这⾥改为检查 right 越界的情况，⻅下图
           if (right < 0 || nums[right] != target)
               return -1;
           return right;
       }
   ```

   

但是前⽂总结的⼆分搜索代码框架仅仅局限于「在有序数组中搜索指定元素」这个基本场景，具体的算法问题没有这么直接，可能你都很难看出这个问题能够⽤到⼆分搜索。

在具体的算法问题中，常⽤到的是「搜索左侧边界」和「搜索右侧边界」这两种场景，很少有让你单独「搜索⼀个元素」。



### 什么问题可以运用二分搜索算法技巧？

⾸先，你要从题⽬中抽象出⼀个⾃变量 x，⼀个关于 x 的函数 f(x)，以及⼀个⽬标值 target。 

同时，x, f(x), target 还要满⾜以下条件：

 	1、f(x) 必须是在 x 上的单调函数（单调增单调减都可以）。 

​	 2、题⽬是让你计算满⾜约束条件 f(x) == target 时的 x 的值。



```java
    // 函数 f 是关于⾃变量 x 的单调函数
    int f(int x) {
        // ...
    }
    // 主函数，在 f(x) == target 的约束下求 x 的最值
    int solution(int[] nums, int target) {
        if (nums.length == 0) return -1;
        // 问⾃⼰：⾃变量 x 的最⼩值是多少？
        int left = ...;
        // 问⾃⼰：⾃变量 x 的最⼤值是多少？
        int right = ... + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
          	
            if (f(mid) == target) {
                // 问⾃⼰：题⽬是求左边界还是右边界？
                // ...
            } else if (f(mid) < target) {
                // 问⾃⼰：怎么让 f(x) ⼤⼀点？
                // ...
            } else if (f(mid) > target) {
                // 问⾃⼰：怎么让 f(x) ⼩⼀点？
                // ...
            }
        }
        return left;
    }
```



具体来说，想要⽤⼆分搜索算法解决问题，分为以下⼏步：

1、确定 x, f(x), target 分别是什么，并写出函数 f 的代码。 

2、找到 x 的取值范围作为⼆分搜索的搜索区间，初始化 left 和 right 变量。 

3、根据题⽬的要求，确定应该使⽤搜索左侧还是搜索右侧的⼆分搜索算法，写出解法代码。







