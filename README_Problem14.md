# 🧩 Problem 14: Longest Common Prefix

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_14-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/longest-common-prefix/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Write a function to find the longest common prefix string amongst an array of strings. If no common prefix exists, return `""`.

🔗 **LeetCode Link:** [Longest Common Prefix - LeetCode](https://leetcode.com/problems/longest-common-prefix/)

---

## 🏷️ Topics
`String` `Trie`

---

## 💡 Examples
**Input:** strs = ["flower","flow","flight"]
**Output:** "fl"

---

## 🧠 Intuition & Approach
1. Initialize prefix with the first word `strs[0]`.
2. For each word in `strs`, shorten `prefix` while `word.indexOf(prefix) != 0`.
3. If prefix becomes empty, return `""`.
4. Return matching prefix.

---

## 💻 Java Solution ([LeetCode_Problem14.java](LeetCode_Problem14.java))

```java
class LP14 {
    public static void main(String args[]){
        String[] strs = {"flower","flow","flight"};
        LP14 obj1 = new LP14();
        String res = obj1.longestCommonPrefix(strs);
        System.out.println(res);
    }
    public static String common(String s1, String s2){
        int n = Math.min(s1.length(),s2.length());
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<n;i++){
            if(s1.charAt(i)==s2.charAt(i))
             sb.append(s1.charAt(i));
            else
             break; 
        }
        return sb.toString();
    }
    public  String longestCommonPrefix(String[] strs) {
        String res = strs[0];

        for(int i=1;i<strs.length;i++){
            res = common(res, strs[i]);
        }
        return res;
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(S)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
