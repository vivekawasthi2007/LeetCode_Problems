# 🧩 Problem 9: Palindrome Number

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_9-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/palindrome-number/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.

🔗 **LeetCode Link:** [Palindrome Number - LeetCode](https://leetcode.com/problems/palindrome-number/)

---

## 🏷️ Topics
`Math`

---

## 💡 Examples
**Input:** x = 121 -> **Output:** true
**Input:** x = -121 -> **Output:** false

---

## 🧠 Intuition & Approach
1. If `x < 0`, return `false` because minus sign cannot be mirrored.
2. Reverse digits mathematically by peeling off digits with `% 10` and `/ 10`.
3. Compare reversed number with original `x`.

---

## 💻 Java Solution ([LeetCode_Problem9.java](../LeetCode_Problem9.java))

```java
class LP9 {
    public boolean isPalindrome(int x) {
       if(x<0){
        return false;
       }
       int original = x;
       int rev = 0;
       while(x>0){
        int digit = x%10;
        rev = rev*10 + digit;
        x = x/10;

       }
      return original == rev;
    }
    public static void main(String args[]){
      LP9 obj1 = new LP9();
      int x = 1221;
      boolean ans = obj1.isPalindrome(x);
      System.out.println(ans);
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(log10(x))` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
