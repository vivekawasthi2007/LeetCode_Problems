# 🧩 Problem 153: Find Minimum in Rotated Sorted Array

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_153-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Suppose an array of length `n` sorted in ascending order is rotated between `1` and `n` times. Given the sorted rotated array `nums` of unique elements, return the minimum element of this array.

You must write an algorithm that runs in `O(log n)` time.

🔗 **LeetCode Link:** [Find Minimum in Rotated Sorted Array - LeetCode](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

---

## 🏷️ Topics
`Array` `Binary Search`

---

## 💡 Examples
**Input:** nums = [3,4,5,1,2]
**Output:** 1
**Explanation:** The original array was [1,2,3,4,5] rotated 3 times.

**Input:** nums = [4,5,6,7,0,1,2]
**Output:** 0
**Explanation:** The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

---

## 🧠 Intuition & Approach
1. Use binary search between `left = 0` and `right = nums.length - 1`.
2. Calculate `mid = left + (right - left) / 2`.
3. Compare `nums[mid]` with `nums[right]`:
4. - If `nums[mid] > nums[right]`, the rotation point (and thus minimum element) must be strictly to the right of `mid`, so `left = mid + 1`.
5. - If `nums[mid] <= nums[right]`, the minimum element is either at `mid` or to its left, so `right = mid`.
6. When `left == right`, `nums[left]` is guaranteed to be the minimum element.

---

## 💻 Java Solution ([LeetCode_Problem153.java](../LeetCode_Problem153.java))

```java
class LP153 {
    static int findMin(int[] nums) {
        int left  = 0;
        int right = nums.length-1;
        while(left<right){
            int mid  = left +(right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid ;
            }
        }
        return nums[left];
    }
    public static void main(String args[]){
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
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
