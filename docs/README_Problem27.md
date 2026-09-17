# 🧩 Problem 27: Remove Element

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_27-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/remove-element/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an array `nums` and a value `val`, remove all instances of `val` in-place and return the number of remaining elements.

🔗 **LeetCode Link:** [Remove Element - LeetCode](https://leetcode.com/problems/remove-element/)

---

## 🏷️ Topics
`Array` `Two Pointers`

---

## 💡 Examples
**Input:** nums = [3,2,2,3], val = 3
**Output:** 2, nums = [2,2,_,_]

---

## 🧠 Intuition & Approach
1. Use slow pointer `k = 0`.
2. Traverse each element with pointer `i`.
3. If `nums[i] != val`, set `nums[k] = nums[i]` and advance `k++`.
4. Return `k`.

---

## 💻 Java Solution ([LeetCode_Problem27.java](../LeetCode_Problem27.java))

```java
class LP27 {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int j = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    public static void main(String args[]){
        LP27 obj1 = new LP27();
        int[] nums = {3,2,2,3};
        int val = 3;
        int ans = obj1.removeElement(nums,val);
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
