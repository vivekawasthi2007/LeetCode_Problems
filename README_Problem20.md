# 🧩 Problem 20: Valid Parentheses

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_20-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/valid-parentheses/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

🔗 **LeetCode Link:** [Valid Parentheses - LeetCode](https://leetcode.com/problems/valid-parentheses/)

---

## 🏷️ Topics
`String` `Stack`

---

## 💡 Examples
**Input:** s = "()[]{}" -> **Output:** true
**Input:** s = "(]" -> **Output:** false

---

## 🧠 Intuition & Approach
1. Use a `Stack<Character>`.
2. For each character:
   - Push expected closing bracket on opening bracket.
   - On closing bracket, pop from stack and verify match.
3. String is valid if stack is empty at the end.

---

## 💻 Java Solution ([LeetCode_Problem20.java](LeetCode_Problem20.java))

```java
import java.util.Stack;
class LP20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray() ){
            if(ch == '(' || ch =='{' || ch =='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();

                if(ch == ')' && top != '(' ||
                   ch == '}' && top != '{' ||
                   ch == ']' && top != '[' ){
                    return false;
                   }

            }

        }
        return stack.isEmpty();
    }
    public static void main(String args[]){
        LP20 obj = new LP20();
        String s = "(){}{[]}";
        boolean ans = obj.isValid(s);
        System.out.println(ans);
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(n)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
