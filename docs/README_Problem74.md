# 🧩 Problem 74: Search a 2D Matrix

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_74-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/search-a-2d-matrix/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
You are given an `m x n` integer matrix `matrix` with the following two properties:
- Each row is sorted in non-decreasing order.
- The first integer of each row is greater than the last integer of the previous row.

Given an integer `target`, return `true` if `target` is in `matrix` or `false` otherwise.

🔗 **LeetCode Link:** [Search a 2D Matrix - LeetCode](https://leetcode.com/problems/search-a-2d-matrix/)

---

## 🏷️ Topics
`Array` `Binary Search` `Matrix`

---

## 💡 Examples
**Input:** matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
**Output:** true

**Input:** matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
**Output:** false

---

## 🧠 Intuition & Approach
1. Treat the `m x n` matrix as a flattened 1D sorted array of length `m * n`.
2. Run binary search from index `left = 0` to `right = m * n - 1`.
3. Convert any 1D index `mid` back to matrix coordinates: `row = mid / n` and `col = mid % n`.
4. If `matrix[row][col] == target`, return `true`.
5. If value is less than target, search right half (`left = mid + 1`); otherwise search left half (`right = mid - 1`).
6. Return `false` if `left > right` without finding the target.

---

## 💻 Java Solution ([LeetCode_Problem74.java](../LeetCode_Problem74.java))

```java
class LP74 {
    static  boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
    public static void main(String args[]){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean ans = searchMatrix(matrix,target);
        System.out.println(ans);
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(log(m * n))` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
