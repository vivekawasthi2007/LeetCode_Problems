# 🧩 Problem 645: Set Mismatch

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_645-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/set-mismatch/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
You have a set of integers `s`, which originally contains all the numbers from `1` to `n`. Unfortunately, due to some error, one of the numbers in `s` got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an integer array `nums` representing the data status of this set after the error, find the number that occurs twice and the number that is missing and return them in the form of an array `[duplicate, missing]`.

🔗 **LeetCode Link:** [Set Mismatch - LeetCode](https://leetcode.com/problems/set-mismatch/)

---

## 🏷️ Topics
`Array` `Hash Table` `Bit Manipulation` `Sorting`

---

## 💡 Examples
**Input:** nums = [1,2,2,4]
**Output:** [2,3]

**Input:** nums = [3,2,2]
**Output:** [2,1]

---

## 🧠 Intuition & Approach
1. Sort the array using cyclic sort by placing each value `nums[i]` at index `nums[i] - 1`.
2. If `nums[i] != nums[correctIdx]`, swap them; otherwise increment pointer `i`.
3. Iterate through the array: the first index where `nums[index] != index + 1` reveals both answers.
4. `nums[index]` is the duplicate number, and `index + 1` is the missing number.
5. Return `new int[]{nums[index], index + 1}`.

---

## 💻 Java Solution ([LeetCode_Problem645.java](../LeetCode_Problem645.java))

```java
import java.util.Arrays;
class LP645 {
    static int[] findErrorNums(int[] nums) {
     int i = 0;
        while(i<nums.length){
            int correctIdx = nums[i] - 1;
            if(nums[i] != nums[correctIdx]){
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }else{
                i++;
            }
        }
        for(int index = 0;index<nums.length;index++){
            if(nums[index] != index+1){
                return new int[]{nums[index],index+1};
            }
        }
    return new int[]{-1,-1};
    }   
   public static void main(String args[]){
    int[] nums = {3,2,2};
    int[] ans = findErrorNums(nums);
    System.out.println(Arrays.toString(ans));
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
