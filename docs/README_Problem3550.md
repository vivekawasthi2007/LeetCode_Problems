# 🧩 Problem 3550: Smallest Index With Digit Sum Equal to Index

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_3550-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
You are given an integer array `nums`.

Return the smallest index `i` such that the sum of the decimal digits of `nums[i]` is equal to `i`. If no such index exists, return `-1`.

🔗 **LeetCode Link:** [Smallest Index With Digit Sum Equal to Index - LeetCode](https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/)

---

## 🏷️ Topics
`Array` `Math`

---

## 💡 Examples
**Input:** nums = [1,3,2]
**Output:** 2
**Explanation:**
- Index 0: nums[0] = 1, digit sum = 1 != 0
- Index 1: nums[1] = 3, digit sum = 3 != 1
- Index 2: nums[2] = 2, digit sum = 2 == 2
The smallest index is 2.

---

## 🧠 Intuition & Approach
1. Iterate sequentially through each index `i` from `0` to `nums.length - 1`.
2. Extract the sum of the digits of `nums[i]` by repeatedly adding `num % 10` and doing `num /= 10`.
3. Check if the digit sum equals `i`.
4. Return `i` immediately upon the first match (ensuring it is the smallest index).
5. If the loop finishes without finding any match, return `-1`.

---

## 💻 Java Solution ([LeetCode_Problem3550.java](../LeetCode_Problem3550.java))

```java
class LP3550 {
    static int smallestIndex(int[] nums) {
        for(int i = 0;i<nums.length;i++)
        {
            int num = nums[i];
            int digit = 0;
            while(num>0){
                digit += num%10;
                num = num/10;
            }
            if(digit == i){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int[] nums = {1,3,2};
        System.out.println(smallestIndex(nums));
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n * \log_{10}(M))` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
