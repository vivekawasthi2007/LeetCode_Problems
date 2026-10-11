# 🧩 Problem 287: Find the Duplicate Number

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_287-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/find-the-duplicate-number/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive.

There is only one repeated number in `nums`, return this repeated number.

🔗 **LeetCode Link:** [Find the Duplicate Number - LeetCode](https://leetcode.com/problems/find-the-duplicate-number/)

---

## 🏷️ Topics
`Array` `Two Pointers` `Binary Search` `Bit Manipulation`

---

## 💡 Examples
**Input:** nums = [1,3,4,2,2]
**Output:** 2

**Input:** nums = [3,1,3,4,2]
**Output:** 3

---

## 🧠 Intuition & Approach
1. Use cyclic sort logic: each number `x` in `[1, n]` belongs at index `x - 1`.
2. While iterating with index `i`:
3. - If `nums[i] != i + 1`, check if `nums[i] == nums[nums[i] - 1]`.
4. - If equal, a duplicate is identified! Return `nums[i]` immediately.
5. - Otherwise, swap `nums[i]` with the element at index `nums[i] - 1`.
6. - If `nums[i] == i + 1`, move to `i++`.

---

## 💻 Java Solution ([LeetCode_Problem287.java](../LeetCode_Problem287.java))

```java
class LP287 {
    static int findDuplicate(int[] nums) {
       
            int i = 0;
            while(i<nums.length){
            if(nums[i] != i+1){
                int correctIdx = nums[i] - 1;
                if(nums[i] != nums[correctIdx]){
                    int temp = nums[i];
                    nums[i] = nums[correctIdx];
                    nums[correctIdx] = temp;
                }else{
                    return nums[i];
                }
            }
        
        else{
                i++;
        } 
        }
        return -1;
    }
    public static void main(String args[]){
        int[] nums = {1,3,6,3,5,2,4};
        System.out.println(findDuplicate(nums));
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
