# 🧩 Problem 66: Plus One

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_66-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/plus-one/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Increment large integer represented by an array of digits by one.

🔗 **LeetCode Link:** [Plus One - LeetCode](https://leetcode.com/problems/plus-one/)

---

## 🏷️ Topics
`Array` `Math`

---

## 💡 Examples
**Input:** digits = [1,2,3] -> **Output:** [1,2,4]
**Input:** digits = [9,9] -> **Output:** [1,0,0]

---

## 🧠 Intuition & Approach
1. Traverse backwards from `n - 1` to 0.
2. If `digits[i] < 9`, increment `digits[i]++` and return `digits`.
3. If 9, set `digits[i] = 0`.
4. If all digits were 9, create array of size `n + 1` with `res[0] = 1`.

---

## 💻 Java Solution ([LeetCode_Problem66.java](LeetCode_Problem66.java))

```java
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1;i>=0;i--){
            if(digits[i]<9)
            {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length +1];
        result[0] = 1;
   
       return result;
    }
    public static void main(String args[]){
        Solution obj1 = new Solution();
        int[] digits = {1,2,3};
        int[] ans = obj1.plusOne(digits);
        System.out.println(java.util.Arrays.toString(ans));
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
