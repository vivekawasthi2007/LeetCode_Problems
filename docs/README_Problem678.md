# 🧩 Problem 678: Valid Parenthesis String

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_678-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/valid-parenthesis-string/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a string `s` containing only three types of characters: `'('`, `')'` and `'*'`, return `true` if `s` is valid.

The following rules define a valid string:
- Any left parenthesis `'('` must have a corresponding right parenthesis `')'`.
- Any right parenthesis `')'` must have a corresponding left parenthesis `'('`.
- Left parenthesis `'('` must go before the corresponding right parenthesis `')'`.
- `'*'` could be treated as a single right parenthesis `')'`, a single left parenthesis `'('`, or an empty string `""`.

🔗 **LeetCode Link:** [Valid Parenthesis String - LeetCode](https://leetcode.com/problems/valid-parenthesis-string/)

---

## 🏷️ Topics
`String` `Dynamic Programming` `Stack` `Greedy`

---

## 💡 Examples
**Input:** s = "()"
**Output:** true

**Input:** s = "(*)"
**Output:** true

**Input:** s = "(*))"
**Output:** true

---

## 🧠 Intuition & Approach
1. Track the range of possible open parentheses count `[minOpen, maxOpen]`.
2. For `'('`: both `minOpen` and `maxOpen` increase by 1.
3. For `')'`: both `minOpen` and `maxOpen` decrease by 1.
4. For `'*'`: could be `(`, `)`, or empty, so `minOpen--` and `maxOpen++`.
5. If `maxOpen < 0` at any point, too many `)` have occurred, making the string invalid; return `false`.
6. Reset `minOpen = Math.max(0, minOpen)` because open count cannot be negative (a star can act as empty).
7. At the end, return `minOpen == 0`.

---

## 💻 Java Solution ([LeetCode_Problem678.java](../LeetCode_Problem678.java))

```java
class LP678 {
    static boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        for(int i = 0;i<s.length();i++){
            char ch  = s.charAt(i);
            if(ch == '('){
                minOpen++;
                maxOpen++;
            }else if(ch ==')'){
                minOpen--;
                maxOpen--;
            }else{
                minOpen--;
                maxOpen++;
            }
            if(maxOpen<0){
                return false;
            }
            if(minOpen<0){
                minOpen = 0;
            }
        }
        return minOpen == 0;
    }
     public static void main(String args[]){
       String s = "(*)";
        System.out.println(checkValidString(s));
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
