# 🧩 Problem 1: Two Sum

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_1-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/two-sum/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

🔗 **LeetCode Link:** [Two Sum - LeetCode](https://leetcode.com/problems/two-sum/)

---

## 🏷️ Topics
`Array` `Hash Table`

---

## 💡 Examples
**Input:** nums = [2,7,11,15], target = 9
**Output:** [0,1]
**Explanation:** Because nums[0] + nums[1] == 9, we return [0, 1].

---

## 🧠 Intuition & Approach
1. Iterate through each element with outer pointer `i` from `0` to `n - 1`.
2. Use an inner pointer `j` from `i + 1` to `n - 1`.
3. Check if `nums[i] + nums[j] == target`.
4. If matching, return indices `new int[]{i, j}`.

---

## 💻 Java Solution ([LeetCode_Problem1.java](LeetCode_Problem1.java))

```java
import java.util.Arrays;
class MyCl {
    public static void main(String args[]){
        int[] nums = {2,7,11,15};
        int target = 9;
        MyCl obj1 = new MyCl();
        int[] result = obj1.twoSum(nums,target);
        System.out.print(Arrays.toString(result));


    }
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
      
    
}
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n^2)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
