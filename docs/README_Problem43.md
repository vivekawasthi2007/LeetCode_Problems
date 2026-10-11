# 🧩 Problem 43: Multiply Strings

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_43-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/multiply-strings/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

🔗 **LeetCode Link:** [Multiply Strings - LeetCode](https://leetcode.com/problems/multiply-strings/)

---

## 🏷️ Topics
`Math` `String` `Simulation`

---

## 💡 Examples
**Input:** num1 = "123", num2 = "456"
**Output:** "56088"

**Input:** num1 = "2", num2 = "3"
**Output:** "6"

---

## 🧠 Intuition & Approach
1. If either input is `"0"`, return `"0"` immediately.
2. Create an array `result` of length `num1.length() + num2.length()` to store individual digit products.
3. Iterate backwards through digits of `num1` (index `i`) and `num2` (index `j`).
4. The product of digits at `i` and `j` affects indices `pos1 = i + j` and `pos2 = i + j + 1`.
5. Add the product to `result[pos2]`, update `result[pos2] = sum % 10`, and carry over to `result[pos1] += sum / 10`.
6. Build the final string skipping leading zeros.

---

## 💻 Java Solution ([LeetCode_Problem43.java](../LeetCode_Problem43.java))

```java
class LP43{

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {

            int digit1 = num1.charAt(i) - '0';

            for (int j = num2.length() - 1; j >= 0; j--) {

                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = product + result[pos2];

                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int num : result) {

            if (sb.length() == 0 && num == 0) {
                continue;
            }

            sb.append(num);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String num1 = "123";
        String num2 = "456";

        String answer = multiply(num1, num2);

        System.out.println("Answer = " + answer);
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(m * n)` |
| **Space Complexity** | `O(m + n)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
