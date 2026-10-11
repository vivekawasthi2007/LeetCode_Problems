# 🧩 Problem 189: Rotate Array

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_189-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/rotate-array/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

🔗 **LeetCode Link:** [Rotate Array - LeetCode](https://leetcode.com/problems/rotate-array/)

---

## 🏷️ Topics
`Array` `Math` `Two Pointers`

---

## 💡 Examples
**Input:** nums = [1,2,3,4,5,6,7], k = 3
**Output:** [5,6,7,1,2,3,4]
**Explanation:**
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

**Input:** nums = [-1,-100,3,99], k = 2
**Output:** [3,99,-1,-100]

---

## 🧠 Intuition & Approach
1. Normalize `k` using modulo: `k = k % nums.length` to handle shifts greater than array length.
2. Use the 3-step reversal algorithm for `O(1)` space in-place rotation:
3. 1. Reverse the entire array from index `0` to `n - 1`.
4. 2. Reverse the first `k` elements from index `0` to `k - 1`.
5. 3. Reverse the remaining `n - k` elements from index `k` to `n - 1`.
6. This places all rotated elements in their correct final positions.

---

## 💻 Java Solution ([LeetCode_Problem189.java](../LeetCode_Problem189.java))

```java
import java.util.Arrays;
class LP189 {
    static void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    static void reverse(int[] nums, int start, int end) {

        while (start < end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
    public static void main(String args[]){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
