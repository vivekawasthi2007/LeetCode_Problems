# 🧩 Problem 448: Find All Numbers Disappeared in an Array

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_448-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an array `nums` of `n` integers where `nums[i]` is in the range `[1, n]`, return an array of all the integers in the range `[1, n]` that do not appear in `nums`.

🔗 **LeetCode Link:** [Find All Numbers Disappeared in an Array - LeetCode](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

---

## 🏷️ Topics
`Array` `Hash Table`

---

## 💡 Examples
**Input:** nums = [4,3,2,7,8,2,3,1]
**Output:** [5,6]

**Input:** nums = [1,1]
**Output:** [2]

---

## 🧠 Intuition & Approach
1. Apply cyclic sort to map each value `nums[i]` to its correct slot `nums[i] - 1`.
2. Swap elements until `nums[i]` is correctly placed or equals the value already at `correct`.
3. In the second pass from index `0` to `n - 1`, any position where `nums[index] != index + 1` indicates that number `index + 1` is missing.
4. Collect and return all such missing numbers.

---

## 💻 Java Solution ([LeetCode_problem448.java](../LeetCode_problem448.java))

```java
import java.util.*;
class LP448 {
    static List<Integer> findDisappearedNumbers(int[] nums) {
           int i = 0;
           
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i]<= nums.length && nums[i] != nums[correct]){
                swap(nums,i,correct);
            }else{
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int index = 0;index<nums.length;index++){
            if(nums[index] != index + 1){
                ans.add(index + 1);
            }
        }
        
    return ans;
    }
     static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public static void main(String args[]){
        int[] nums = {4,3,2,7,8,2,3,1};
        

        System.out.println(findDisappearedNumbers(nums));
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
