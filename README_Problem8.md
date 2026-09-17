# 🧩 Problem 8: String to Integer (atoi)

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_8-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/string-to-integer-atoi/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Implement `myAtoi(string s)` to convert a string to a 32-bit signed integer according to standard atoi specifications.

🔗 **LeetCode Link:** [String to Integer (atoi) - LeetCode](https://leetcode.com/problems/string-to-integer-atoi/)

---

## 🏷️ Topics
`String`

---

## 💡 Examples
**Input:** s = " -042" -> **Output:** -42
**Input:** s = "1337c0d3" -> **Output:** 1337

---

## 🧠 Intuition & Approach
1. Skip leading whitespaces.
2. Check for sign indicator (`+` or `-`).
3. Parse consecutive digits into a numeric accumulator.
4. Check bounds against `Integer.MAX_VALUE` and `Integer.MIN_VALUE` to handle overflow and clamp.

---

## 💻 Java Solution ([LeetCode_Problem8.java](LeetCode_Problem8.java))

```java
class LP8 {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // 1. Leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Sign
        int sign = 1;

        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } 
        else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        // 3. Convert digits
        long num = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            num = num * 10 + digit;

            // 4. Check overflow
            if (num * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (num * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(num * sign);
    }
    public static void main(String args[]){
        LP8 obj1 = new LP8();
        String s =  " -042";
        int ans = obj1.myAtoi(s);
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
