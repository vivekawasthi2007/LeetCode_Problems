# 🧩 Problem 35: Search Insert Position

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_35-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/search-insert-position/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a sorted array of distinct integers and a target value, return index if found or insertion index in O(log n) time.

🔗 **LeetCode Link:** [Search Insert Position - LeetCode](https://leetcode.com/problems/search-insert-position/)

---

## 🏷️ Topics
`Array` `Binary Search`

---

## 💡 Examples
**Input:** nums = [1,3,5,6], target = 5 -> **Output:** 2
**Input:** nums = [1,3,5,6], target = 2 -> **Output:** 1

---

## 🧠 Intuition & Approach
1. Initialize `low = 0` and `high = n - 1`.
2. Binary search: If `nums[mid] == target`, return `mid`.
3. If `nums[mid] < target`, `low = mid + 1`; else `high = mid - 1`.
4. When loop finishes, `low` is the exact insertion index.

---

## 💻 Java Solution ([LeetCode_Problem35.java](../LeetCode_Problem35.java))

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
       int left = 0;
       int right = nums.length - 1;
       while(left<=right){
        int mid = left +(right - left)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid]< target){
            left = mid + 1;
        }else
        {
            right = mid - 1;

        }
       }
       return left; 
    }
    public static void main(String args[]){
        Solution obj1 = new Solution();
        int[] nums = {1,3,5,6};
        int target = 5;
        int ans = obj1.searchInsert(nums,target);
        System.out.println(ans);

    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(log n)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
