# 🧩 Problem 13: Roman to Integer

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_13-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/roman-to-integer/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a roman numeral string `s`, convert it to an integer.

🔗 **LeetCode Link:** [Roman to Integer - LeetCode](https://leetcode.com/problems/roman-to-integer/)

---

## 🏷️ Topics
`Hash Table` `Math` `String`

---

## 💡 Examples
**Input:** s = "MCMXCIV"
**Output:** 1994

---

## 🧠 Intuition & Approach
1. Map Roman characters to values (`I=1, V=5, X=10, L=50, C=100, D=500, M=1000`).
2. Iterate through string: If current value is less than next value (e.g. `IV`), subtract it.
3. Otherwise, add current value.
4. Return total accumulator.

---

## 💻 Java Solution ([LeetCode_Problem13.java](LeetCode_Problem13.java))

```java
class LP13 {
    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0;i<s.length();i++){
            int current = value(s.charAt(i));
            
            if(i+1<s.length() && current<value(s.charAt(i+1))){
                result -= current;
            }else{
                result += current;
            }

        }
        return result;
    }
    public int value(char ch){
        switch(ch){
        case 'I':return 1;
        case 'V':return 5;
        case 'X':return 10;
        case 'L':return 50;
        case 'C':return 100;
        case 'D':return 500;
        case 'M':return 1000;
   
        }
        return 0;
    }
    public static void main(String args[]){
        LP13 obj = new LP13();
        String s = "MMMCCCXLIII";
        int ans = obj.romanToInt(s);
        System.out.println(ans);

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
