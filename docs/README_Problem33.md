# 🧩 Problem 33: Search in Rotated Sorted Array

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_33-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/search-in-rotated-sorted-array/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a rotated sorted array and an integer `target`, return index of `target` in O(log n) time, or -1 if not present.

🔗 **LeetCode Link:** [Search in Rotated Sorted Array - LeetCode](https://leetcode.com/problems/search-in-rotated-sorted-array/)

---

## 🏷️ Topics
`Array` `Binary Search`

---

## 💡 Examples
**Input:** nums = [4,5,6,7,0,1,2], target = 0
**Output:** 4

---

## 🧠 Intuition & Approach
1. Binary search: Calculate `mid`.
2. Check if left half `[low..mid]` is sorted or right half `[mid..high]` is sorted.
3. Check if target lies within the boundaries of the sorted half.
4. Narrow search to appropriate half; return index or -1.

---

## 💻 Java Solution ([LeetCode_Problem33.java](../LeetCode_Problem33.java))

```java
class LP33 {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left +(right-left)/2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[left]<= nums[mid]){
                if(nums[left]<= target && target<nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
             if(nums[mid]< target && target<=nums[right]){
                left = mid+1;
             }else{
                right = mid-1;
             }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        LP33 obj1 = new LP33();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int ans = obj1.search(nums,target);
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
