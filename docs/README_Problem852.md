# 🧩 Problem 852: Peak Index in a Mountain Array

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_852-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/peak-index-in-a-mountain-array/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
An array `arr` is a mountain if the following properties hold:
- `arr.length >= 3`
- There exists some `i` with `0 < i < arr.length - 1` such that:
  - `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
  - `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`

Given a mountain array `arr`, return the index `i` of the peak element. You must solve it in `O(log n)` time complexity.

🔗 **LeetCode Link:** [Peak Index in a Mountain Array - LeetCode](https://leetcode.com/problems/peak-index-in-a-mountain-array/)

---

## 🏷️ Topics
`Array` `Binary Search`

---

## 💡 Examples
**Input:** arr = [0,1,0]
**Output:** 1

**Input:** arr = [0,2,1,0]
**Output:** 1

**Input:** arr = [0,1,2,4,5,6,5,3,2,1]
**Output:** 5

---

## 🧠 Intuition & Approach
1. Binary search on the mountain array using `start = 0` and `end = arr.length - 1`.
2. Compare `arr[mid]` with `arr[mid + 1]`:
3. - If `arr[mid] > arr[mid + 1]`, we are in the decreasing descending slope of the mountain, meaning the peak is either at `mid` or to its left (`end = mid`).
4. - If `arr[mid] < arr[mid + 1]`, we are in the ascending slope, meaning the peak must be to the right (`start = mid + 1`).
5. When `start == end`, both pointers converge at the peak index.

---

## 💻 Java Solution ([LeetCode_Problem852.java](../LeetCode_Problem852.java))

```java
class LP852 {
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        if(arr.length == 0){
            return -1;
        }
        while(start<end){
            int mid = start +(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end= mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    public static void main(String args[]){
        int[] arr = {0,1,2,4,5,6,5,3,2,1};
        System.out.println(peakIndexInMountainArray(arr));
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
