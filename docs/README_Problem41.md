# 🧩 Problem 41: First Missing Positive

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_41-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/first-missing-positive/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an unsorted integer array `nums`, return the smallest positive integer that is not present in `nums`.

You must implement an algorithm that runs in `O(n)` time and uses `O(1)` auxiliary space.

🔗 **LeetCode Link:** [First Missing Positive - LeetCode](https://leetcode.com/problems/first-missing-positive/)

---

## 🏷️ Topics
`Array` `Hash Table`

---

## 💡 Examples
**Input:** nums = [1,2,0]
**Output:** 3
**Explanation:** The numbers in the range [1,2] are all in the array.

**Input:** nums = [3,4,-1,1]
**Output:** 2
**Explanation:** 1 is in the array, but 2 is missing.

---

## 🧠 Intuition & Approach
1. Use cyclic sort to place each number `x` in range `[1, n]` at index `x - 1`.
2. Iterate with index `i`: if `nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[correctIdx]`, swap `nums[i]` with `nums[correctIdx]`. Otherwise advance `i`.
3. After rearranging in-place, perform a linear scan: the first index where `nums[index] != index + 1` identifies `index + 1` as the smallest missing positive integer.
4. If all indices `0` through `n - 1` have correct values, the answer is `n + 1`.

---

## 💻 Java Solution ([LeetCode_Problem41.java](../LeetCode_Problem41.java))

```java
class LP41 {
    static int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i<nums.length){
            int correctIdx = nums[i] - 1;
            if(nums[i]>0 && nums[i]<nums.length && nums[i] != nums[correctIdx]){
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }else{
                i++;
            }
        }
        for(int index = 0;index<nums.length;index++){
            if(nums[index] != index + 1){
                return index+1;
            }
        }
    return nums.length+1;
    }
  public static void main(String args[]){
    int[] nums = {1,2,0};
    System.out.println(firstMissingPositive(nums));
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
