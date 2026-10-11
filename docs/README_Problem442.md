# 🧩 Problem 442: Find All Duplicates in an Array

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_442-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/find-all-duplicates-in-an-array/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an integer array `nums` of length `n` where all the integers of `nums` are in the range `[1, n]` and each integer appears at most twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in `O(n)` time and uses only constant auxiliary space.

🔗 **LeetCode Link:** [Find All Duplicates in an Array - LeetCode](https://leetcode.com/problems/find-all-duplicates-in-an-array/)

---

## 🏷️ Topics
`Array` `Hash Table`

---

## 💡 Examples
**Input:** nums = [4,3,2,7,8,2,3,1]
**Output:** [2,3]

**Input:** nums = [1,1,2]
**Output:** [1]

---

## 🧠 Intuition & Approach
1. Use cyclic sort to position every value `nums[i]` at index `nums[i] - 1`.
2. While traversing, if `nums[i] != nums[correctIdx]`, swap them into place; otherwise advance `i++`.
3. In a second pass through the array, check indices where `nums[index] != index + 1`.
4. Any element not matching its 1-based index is a duplicate; add `nums[index]` to the result list.

---

## 💻 Java Solution ([LeetCode_Problem442.java](../LeetCode_Problem442.java))

```java
import java.util.*;
class LP442 {
    static  List<Integer> findDuplicates(int[] nums) {
       int i = 0;
        while(i<nums.length){
            
           
            int correctIdx = nums[i] - 1;
            if(nums[i] != nums[correctIdx]){
                 int temp = nums[i];
                 nums[i] = nums[correctIdx];
                 nums[correctIdx] = temp;
                }
                
              
               else{
                   i++;
                } 
        }
        List<Integer> ans = new ArrayList<>();
        for(int index = 0;index<nums.length;index++){
            if(nums[index] != index+1){
                ans.add(nums[index]);
            }

        }

        return ans;
    }  
public static void main(String args[]){
  int[] nums = {4,3,2,7,8,2,3,1};
  System.out.println(findDuplicates(nums));

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
