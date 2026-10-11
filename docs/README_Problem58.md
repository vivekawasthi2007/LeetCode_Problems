# 🧩 Problem 58: Length of Last Word

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_58-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/length-of-last-word/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a string `s` consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

🔗 **LeetCode Link:** [Length of Last Word - LeetCode](https://leetcode.com/problems/length-of-last-word/)

---

## 🏷️ Topics
`String`

---

## 💡 Examples
**Input:** s = "Hello World"
**Output:** 5
**Explanation:** The last word is "World" with length 5.

**Input:** s = "   fly me   to   the moon  "
**Output:** 4
**Explanation:** The last word is "moon" with length 4.

---

## 🧠 Intuition & Approach
1. Start from the end of the string (`s.length() - 1`).
2. Skip all trailing whitespace characters until reaching a non-space character.
3. Count consecutive non-space characters until encountering a space or reaching the start of the string.
4. Return the count as the length of the last word.

---

## 💻 Java Solution ([LeetCode_Problem58.java](../LeetCode_Problem58.java))

```java
class LP58 {
    static int lengthOfLastWord(String s) {
        int i = s.length()-1;
        while(i>=0 && s.charAt(i) == ' '){
            i--;
        }
        int count = 0;
        while(i>=0 && s.charAt(i) != ' '){
           count++;
            i--;
        }
     return count;
    }
   public static void main(String args[]){
     String s = "Hello World";
     System.out.println(lengthOfLastWord(s));
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
