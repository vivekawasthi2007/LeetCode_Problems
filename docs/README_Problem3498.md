# 🧩 Problem 3498: Reverse Degree of a String

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_3498-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/reverse-degree-of-a-string/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a string `s`, the reverse value of a lowercase English letter is `26 - (ch - 'a')` (where `'a'` is 26, `'b'` is 25, ..., `'z'` is 1).

The reverse degree of string `s` is the sum of `reverseValue * position` for each character in `s` using 1-based index position.

Return the reverse degree of `s`.

🔗 **LeetCode Link:** [Reverse Degree of a String - LeetCode](https://leetcode.com/problems/reverse-degree-of-a-string/)

---

## 🏷️ Topics
`String` `Math`

---

## 💡 Examples
**Input:** s = "abc"
**Output:** 148
**Explanation:**
- 'a' at position 1: reverseValue = 26 - ('a' - 'a') = 26, product = 26 * 1 = 26
- 'b' at position 2: reverseValue = 26 - ('b' - 'a') = 25, product = 25 * 2 = 50
- 'c' at position 3: reverseValue = 26 - ('c' - 'a') = 24, product = 24 * 3 = 72
Total sum = 26 + 50 + 72 = 148.

---

## 🧠 Intuition & Approach
1. Initialize accumulator `sum = 0`.
2. Iterate through each character of string `s` with index `i` from `0` to `s.length() - 1`.
3. Compute reverse alphabet value `reverseValue = 26 - (s.charAt(i) - 'a')`.
4. The 1-based position is `position = i + 1`.
5. Accumulate `reverseValue * position` into `sum`.
6. Return `sum`.

---

## 💻 Java Solution ([LeetCode_Problem3498.java](../LeetCode_Problem3498.java))

```java
class LP3498 {
    static int reverseDegree(String s) {
       int sum = 0;
       for(int i=0;i<s.length();i++){
        int reverseValue = 26-(s.charAt(i) - 'a');
        int position = i+1;
        sum += reverseValue*position;

       } 
       return sum;
    }
    public static void main(String args[]){
        String s = "abc";
        System.out.println(reverseDegree(s));
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
