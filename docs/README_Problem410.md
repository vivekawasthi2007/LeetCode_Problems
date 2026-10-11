# 🧩 Problem 410: Split Array Largest Sum

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_410-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/split-array-largest-sum/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an integer array `nums` and an integer `k` (or `m`), split `nums` into `k` non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

🔗 **LeetCode Link:** [Split Array Largest Sum - LeetCode](https://leetcode.com/problems/split-array-largest-sum/)

---

## 🏷️ Topics
`Array` `Binary Search` `Dynamic Programming` `Greedy`

---

## 💡 Examples
**Input:** nums = [7,2,5,10,8], m = 2
**Output:** 18
**Explanation:** There are four ways to split nums into two subarrays. The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

---

## 🧠 Intuition & Approach
1. Use binary search on the answer: the minimum possible largest subarray sum is `start = max(nums)` (when each element is its own subarray), and the maximum is `end = sum(nums)` (when all elements are in one subarray).
2. For each candidate maximum sum `mid = start + (end - start) / 2`, greedily count the number of subarrays (`pieces`) needed.
3. Iterate through numbers and accumulate subarray sum: if adding `num` exceeds `mid`, start a new subarray (`pieces++`, `sum = num`).
4. If `pieces > m`, the allowed maximum `mid` is too small, so increase lower bound `start = mid + 1`.
5. Otherwise, `mid` is achievable; try a smaller bound `end = mid`.
6. Return `end` when `start == end`.

---

## 💻 Java Solution ([LeetCode_Problem410.java](../LeetCode_Problem410.java))

```java
class LP410 {
    static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        for(int i=0;i<nums.length;i++){
            start = Math.max(start,nums[i]);
            end += nums[i];
        }
        while(start<end){
            int mid = start + (end-start)/2;
            int sum = 0;
            int pieces = 1;
            for(int num : nums){
                if(sum + num>mid){
                    sum = num;
                    pieces++;
                }else{
                    sum += num;
                }
            }
            if(pieces > m){
                start = mid + 1;
            }
            else{
                end = mid ;
            }
        }
        return end;
    }
    public static void main(String args[]){
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(nums,m));
    }

}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n * \log(\sum nums))` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
