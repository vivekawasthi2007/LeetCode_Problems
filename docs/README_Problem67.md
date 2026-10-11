# 🧩 Problem 67: Add Binary

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_67-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/add-binary/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given two binary strings `a` and `b`, return their sum as a binary string.

🔗 **LeetCode Link:** [Add Binary - LeetCode](https://leetcode.com/problems/add-binary/)

---

## 🏷️ Topics
`Math` `String` `Bit Manipulation` `Simulation`

---

## 💡 Examples
**Input:** a = "11", b = "1"
**Output:** "100"

**Input:** a = "1010", b = "1011"
**Output:** "10101"

---

## 🧠 Intuition & Approach
1. Use two pointers `i = a.length() - 1` and `j = b.length() - 1` starting from the rightmost bits.
2. Maintain a `carry` variable initialized to `0`.
3. In each step, add the corresponding bit from string `a` (if `i >= 0`) and string `b` (if `j >= 0`) to `carry`.
4. Append `sum % 2` to a `StringBuilder`, and update `carry = sum / 2`.
5. After exhausting both strings and `carry`, reverse the `StringBuilder` and return.

---

## 💻 Java Solution ([LeetCode_Problem67.java](../LeetCode_Problem67.java))

```java
class LP67 {
    static String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        StringBuilder ans = new StringBuilder();
        while(i >= 0 || j >= 0 || carry != 0){
            int sum = carry;
            if(i>=0){
                sum = sum + (a.charAt(i) - '0');
                i--;
            }
            if(j>=0){
                sum = sum + (b.charAt(j) - '0');
                j--;
            }
            ans.append(sum%2);
            carry = sum/2;
        }
        return ans.reverse().toString();
    }
        public static void main(String args[]){
        String a  = "11";
        String b = "1";
        
        System.out.println(addBinary(a,b));
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(max(m, n))` |
| **Space Complexity** | `O(max(m, n))` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
