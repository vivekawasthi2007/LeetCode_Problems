# 🧩 Problem 268: Missing Number

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_268-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/missing-number/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

🔗 **LeetCode Link:** [Missing Number - LeetCode](https://leetcode.com/problems/missing-number/)

---

## 🏷️ Topics
`Array` `Hash Table` `Math` `Binary Search` `Bit Manipulation` `Sorting`

---

## 💡 Examples
**Input:** nums = [3,0,1]
**Output:** 2
**Explanation:** n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

---

## 🧠 Intuition & Approach
1. Apply cyclic sort: each number `nums[i]` should ideally reside at index `nums[i]`.
2. While iterating with pointer `i`:
3. - If `nums[i] < nums.length` and `nums[i] != nums[nums[i]]`, swap `nums[i]` into its correct slot.
4. - Otherwise, advance `i++`.
5. Scan the sorted array: the first index where `nums[index] != index` is the missing number.
6. If all indices match their values, `n` is the missing number.

---

## 💻 Java Solution ([LeetCode_Problem268.java](../LeetCode_Problem268.java))

```java
class LP268{
    static int missingNumber(int[] nums){
        int i = 0;
        while(i<nums.length){
            int correctIdx = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[correctIdx]){
               swap(nums,i,correctIdx);
            }else{
                i++;
            }
        }
        //find missing index
        for(int index = 0;index<nums.length;index++){
            if(nums[index] != index){
                return index;
            }
        }
        return nums.length;
    }
    static void swap(int[] nums,int i,int correctIdx){
         int temp = nums[i];
         nums[i] = nums[correctIdx];
        nums[correctIdx] = temp;
    }
    public static void main(String args[]){
        int[] nums = {3,0,1};
        
        System.out.println(missingNumber(nums));
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
