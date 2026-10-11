# 🧩 Problem 22: Generate Parentheses

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_22-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/generate-parentheses/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given `n` pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

🔗 **LeetCode Link:** [Generate Parentheses - LeetCode](https://leetcode.com/problems/generate-parentheses/)

---

## 🏷️ Topics
`String` `Dynamic Programming` `Backtracking`

---

## 💡 Examples
**Input:** n = 3
**Output:** ["((()))","(()())","(())()","()(())","()()()"]

**Input:** n = 1
**Output:** ["()"]

---

## 🧠 Intuition & Approach
1. Use recursive backtracking to generate valid combinations of parentheses.
2. Keep track of the number of open `(` and close `)` brackets added so far.
3. If `open < n`, append an open bracket `(` and recurse.
4. If `close < open`, append a close bracket `)` and recurse to ensure the string remains well-formed.
5. When the length of the string reaches `2 * n`, add the completed string to the results list.

---

## 💻 Java Solution ([LeetCode_Problem22.java](../LeetCode_Problem22.java))

```java
import java.util.*;
class LP22 {
    static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("",0,0,n,ans);
        return ans;
    }
    static void generate(String s, int open,int close,int n,List<String> ans){
        if(s.length() == 2*n){
            ans.add(s);
            return;
        }
        if(open<n){
            generate(s+"(",open+1,close,n,ans);
        }
        if(close < open){
            generate(s+")",open,close+1,n,ans);
        }
    } 
public static void main(String args[]){
    int n = 3;
    System.out.println(generateParenthesis(n));
}
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(4^n / \sqrt{n})` |
| **Space Complexity** | `O(n)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
