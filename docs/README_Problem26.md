# 🧩 Problem 26: Remove Duplicates from Sorted Array

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_26-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Remove duplicates in-place from a sorted array such that each unique element appears once. Return `k`, number of unique elements.

🔗 **LeetCode Link:** [Remove Duplicates from Sorted Array - LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

---

## 🏷️ Topics
`Array` `Two Pointers`

---

## 💡 Examples
**Input:** nums = [1,1,2]
**Output:** 2, nums = [1,2,_]

---

## 🧠 Intuition & Approach
1. Slow pointer `k = 1`.
2. Iterate fast pointer `i` from 1 to `n - 1`.
3. If `nums[i] != nums[i - 1]`, assign `nums[k] = nums[i]` and increment `k++`.
4. Return `k`.

---

## 💻 Java Solution ([LeetCode_Problem26.java](../LeetCode_Problem26.java))

```java
class LP26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int j = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
               nums[j] = nums[i];
               j++;
            }
        }
        return j;
    }
    public static void main(String args[]){
        LP26 obj1 = new LP26();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int ans  = obj1.removeDuplicates(nums);
        System.out.println(ans);
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
