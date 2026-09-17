# 🧩 Problem 3: Longest Substring Without Repeating Characters

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_3-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a string `s`, find the length of the longest substring without duplicate characters.

🔗 **LeetCode Link:** [Longest Substring Without Repeating Characters - LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

---

## 🏷️ Topics
`Hash Table` `String` `Sliding Window`

---

## 💡 Examples
**Input:** s = "abcabcbb"
**Output:** 3
**Explanation:** The answer is "abc", with a length of 3.

---

## 🧠 Intuition & Approach
1. Maintain a sliding window using two pointers `left = 0` and `right = 0`.
2. As `right` expands, check if character `s.charAt(right)` was seen between `left` and `right - 1`.
3. If duplicate found at index `i`, slide `left = i + 1`.
4. Update `maxLength = Math.max(maxLength, right - left + 1)`.

---

## 💻 Java Solution ([LeetCode_Problem3.java](../LeetCode_Problem3.java))

```java
class LP3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; 
        int maxLength = 0;
        for(int right = 0;right<s.length();right++){
            for(int i =left;i<right;i++){
                if(s.charAt(i) == s.charAt(right)){
                    left = i+1;
                    break;
                }
            }
            maxLength = Math.max(maxLength,right - left +1);
        }
        return maxLength;
    }
    public static void main(String args[]){
        String s = "abcabcbb";
        LP3 obj1 = new LP3();
        int ans = obj1.lengthOfLongestSubstring(s);
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
