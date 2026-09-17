# 🧩 Problem 1295: Find Numbers with Even Number of Digits

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_1295-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/find-numbers-with-even-number-of-digits/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an array `nums` of integers, return how many of them contain an even number of digits.

🔗 **LeetCode Link:** [Find Numbers with Even Number of Digits - LeetCode](https://leetcode.com/problems/find-numbers-with-even-number-of-digits/)

---

## 🏷️ Topics
`Array` `Math`

---

## 💡 Examples
**Input:** nums = [12,345,2,6,7896]
**Output:** 2 (12 and 7896 have even digit count)

---

## 🧠 Intuition & Approach
1. Iterate through each number in `nums`.
2. Count number of digits (either mathematically with `/ 10` or `String.valueOf(num).length()`).
3. If `digitCount % 2 == 0`, increment count.
4. Return count.

---

## 💻 Java Solution ([LeetCode_Problem1295.java](../LeetCode_Problem1295.java))

```java
class LP1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            if(even(num)){
                count++;
            }
        }
        return count;
        
    }
    static boolean even(int num){
       int digitOfNumber = digits(num);
       if(digitOfNumber%2 ==0){
         return true;
       }else{
        return false;
       }
    }
    static int digits(int num){
        int count = 0;
        while(num>0){
            count++;
            num = num/10;
        }
        return count;
    }
    public static void main(String args[]){
        LP1295 obj1 = new LP1295();
        int[] nums = {12,3,5,56,7,234563,567,6787};
        int ans = obj1.findNumbers(nums);
        System.out.println(ans);
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n * d)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
