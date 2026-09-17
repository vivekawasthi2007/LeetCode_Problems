# 🧩 Problem 5: Longest Palindromic Substring

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_5-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/longest-palindromic-substring/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a string `s`, return the longest palindromic substring in `s`.

🔗 **LeetCode Link:** [Longest Palindromic Substring - LeetCode](https://leetcode.com/problems/longest-palindromic-substring/)

---

## 🏷️ Topics
`String` `Two Pointers` `Dynamic Programming`

---

## 💡 Examples
**Input:** s = "babad"
**Output:** "bab" (or "aba")

---

## 🧠 Intuition & Approach
1. Expand around center: A palindrome mirrors around its center.
2. For each index `i`, expand outwards for:
   - Odd length palindrome: center `(i, i)`
   - Even length palindrome: center `(i, i + 1)`
3. Expand while `s.charAt(left) == s.charAt(right)`.
4. Track and return the longest palindromic substring found.

---

## 💻 Java Solution ([LeetCode_Problem5.java](LeetCode_Problem5.java))

```java
class LP5 {
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        String answer = "";
        for(int i = 0;i<s.length();i++){
            String odd  = expand(s,i,i);
            String even = expand(s,i,i+1);

            if(odd.length() > answer.length()){
                answer = odd;
            }
            if(even.length() > answer.length()){
                answer = even;
            }
        }
        return answer;
    }
    public String expand(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
    public static void main(String args[]){
        String s = "babad";
        LP5 obj = new LP5();
        String ans = obj.longestPalindrome(s);
        System.out.println(ans);
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n^2)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
