# 🧩 Problem 34: Find First and Last Position of Element in Sorted Array

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_34-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Find starting and ending position of a target value in a sorted array in O(log n) time.

🔗 **LeetCode Link:** [Find First and Last Position of Element in Sorted Array - LeetCode](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

---

## 🏷️ Topics
`Array` `Binary Search`

---

## 💡 Examples
**Input:** nums = [5,7,7,8,8,10], target = 8
**Output:** [3,4]

---

## 🧠 Intuition & Approach
1. Binary search 1 (First index): When `nums[mid] == target`, save `mid` and continue search left (`high = mid - 1`).
2. Binary search 2 (Last index): When `nums[mid] == target`, save `mid` and continue search right (`low = mid + 1`).
3. Return `[first, last]`.

---

## 💻 Java Solution ([LeetCode_Problem34.java](../LeetCode_Problem34.java))

```java
class LP34 {

    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }


    
    public int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                answer = mid;

               
                right = mid - 1;

            } else if (nums[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return answer;
    }


   
    public int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                answer = mid;

              
                left = mid + 1;

            } else if (nums[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return answer;
    }
    public static void main(String args[]){
        LP34 obj1 = new LP34();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int first = obj1.findFirst(nums,target);
        int last = obj1.findLast(nums,target);
        int[] res = {first,last};
        System.out.println(java.util.Arrays.toString(res));
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
