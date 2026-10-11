# 🧩 Problem 28: Find the Index of the First Occurrence in a String

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_28-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.

🔗 **LeetCode Link:** [Find the Index of the First Occurrence in a String - LeetCode](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)

---

## 🏷️ Topics
`Two Pointers` `String` `String Matching`

---

## 💡 Examples
**Input:** haystack = "sadbutsad", needle = "sad"
**Output:** 0
**Explanation:** "sad" occurs at index 0 and 6. The first occurrence is at index 0.

**Input:** haystack = "leetcode", needle = "leeto"
**Output:** -1
**Explanation:** "leeto" did not occur in "leetcode", so we return -1.

---

## 🧠 Intuition & Approach
1. Check every potential starting index `i` in `haystack` from `0` to `n - m`.
2. For each starting index, compare characters between `haystack` and `needle` one by one.
3. If all characters match (`j == m`), return starting index `i`.
4. If no complete match is found across all positions, return `-1`.

---

## 💻 Java Solution ([LeetCode_Problem28.java](../LeetCode_Problem28.java))

```java
class LP28 {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }
    public static void main(String args[]){
        LP28 obj = new LP28();
        String haystack = "sadbutsad";
        String needle = "sad";
        int ans = obj.strStr(haystack, needle);
        System.out.println(ans);

    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O((n - m + 1) * m)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
