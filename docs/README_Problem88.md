# 🧩 Problem 88: Merge Sorted Array

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_88-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/merge-sorted-array/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

Merge `nums1` and `nums2` into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array `nums1`. To accommodate this, `nums1` has a length of `m + n`.

🔗 **LeetCode Link:** [Merge Sorted Array - LeetCode](https://leetcode.com/problems/merge-sorted-array/)

---

## 🏷️ Topics
`Array` `Two Pointers` `Sorting`

---

## 💡 Examples
**Input:** nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
**Output:** [1,2,2,3,5,6]
**Explanation:** The arrays we are merging are [1,2,3] and [2,5,6]. The result of the merge is [1,2,2,3,5,6].

---

## 🧠 Intuition & Approach
1. Merge from the back of `nums1` to avoid overwriting existing elements.
2. Initialize three pointers: `i = m - 1` (last active element in nums1), `j = n - 1` (last element in nums2), and `k = m + n - 1` (end of nums1 array buffer).
3. Compare `nums1[i]` and `nums2[j]`. Place the larger value at `nums1[k]` and decrement the corresponding pointer.
4. After the main loop, copy any remaining elements from `nums2` into `nums1` using pointer `j`.
5. Remaining elements in `nums1` are already in their correct places.

---

## 💻 Java Solution ([LeetCode_Problem88.java](../LeetCode_Problem88.java))

```java
import java.util.Arrays;
class LP88 {
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String args[]){
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
       }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(m + n)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
