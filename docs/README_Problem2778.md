# 🧩 Problem 2778: Sum of Squares of Special Elements

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_2778-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/sum-of-squares-of-special-elements/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
You are given a 1-indexed integer array `nums` of length `n`.

An element `nums[i]` of `nums` is called special if `i` divides `n`, i.e. `n % i == 0`.

Return the sum of the squares of all special elements of `nums`.

🔗 **LeetCode Link:** [Sum of Squares of Special Elements - LeetCode](https://leetcode.com/problems/sum-of-squares-of-special-elements/)

---

## 🏷️ Topics
`Array` `Math` `Simulation`

---

## 💡 Examples
**Input:** nums = [1,2,3,4]
**Output:** 21
**Explanation:** There are exactly 3 special elements in nums: nums[1] since 1 divides 4, nums[2] since 2 divides 4, and nums[4] since 4 divides 4. Hence, sum of squares = 1*1 + 2*2 + 4*4 = 1 + 4 + 16 = 21.

---

## 🧠 Intuition & Approach
1. Let `n = nums.length`.
2. Iterate through 0-based indices `i` from `0` to `n - 1`.
3. Check if the 1-based index `(i + 1)` divides `n` evenly (`n % (i + 1) == 0`).
4. If it divides evenly, compute `nums[i] * nums[i]` and add it to running sum `sum`.
5. Return `sum`.

---

## 💻 Java Solution ([LeetCode_Problem2778.java](../LeetCode_Problem2778.java))

```java
class LP2778 {
    static int sumOfSquares(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i<n;i++){
            if(n % (i+1) == 0){
              sum += nums[i]*nums[i];
            
        }
        }
        return sum;
    }
       public static void main(String args[]){
       
        int[] nums = {1,2,3,4};
        System.out.println(sumOfSquares(nums));
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
