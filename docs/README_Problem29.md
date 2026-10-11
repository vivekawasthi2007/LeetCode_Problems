# 🧩 Problem 29: Divide Two Integers

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_29-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/divide-two-integers/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given two integers `dividend` and `divisor`, divide two integers without using multiplication, division, and mod operator. Return the quotient after dividing `dividend` by `divisor`.

The integer division should truncate toward zero. If the quotient is strictly greater than `2^31 - 1`, return `2^31 - 1`, and if the quotient is strictly less than `-2^31`, return `-2^31`.

🔗 **LeetCode Link:** [Divide Two Integers - LeetCode](https://leetcode.com/problems/divide-two-integers/)

---

## 🏷️ Topics
`Math` `Bit Manipulation`

---

## 💡 Examples
**Input:** dividend = 10, divisor = 3
**Output:** 3
**Explanation:** 10/3 = 3.33333.. which is truncated to 3.

**Input:** dividend = 7, divisor = -3
**Output:** -2
**Explanation:** 7/-3 = -2.33333.. which is truncated to -2.

---

## 🧠 Intuition & Approach
1. Handle edge cases such as `dividend == Integer.MIN_VALUE && divisor == -1`, which overflows 32-bit signed integer and should return `Integer.MAX_VALUE`.
2. Determine the sign of the quotient using XOR: `(dividend < 0) ^ (divisor < 0)`.
3. Convert both numbers to positive `long` values to avoid integer overflow issues during subtraction.
4. Use bit shifting (`temp << 1`, `multiple << 1`) for exponential subtraction, finding the largest multiple of divisor that can be subtracted from the dividend at each step.
5. Subtract the shifted divisor, accumulate the corresponding power of two in the quotient, and repeat until the remainder is smaller than divisor.
6. Apply the appropriate sign and clamp within 32-bit signed integer bounds.

---

## 💻 Java Solution ([LeetCode_Problem29.java](../LeetCode_Problem29.java))

```java
class LP29 {
    public int divide(int dividend, int divisor) {

        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

       
        boolean negative = (dividend < 0) ^ (divisor < 0);

        
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        
        while (a >= b) {

            long temp = b;
            long multiple = 1;

            while (a >= (temp << 1)) {
                temp = temp << 1;
                multiple = multiple << 1;
            }

            a = a - temp;
            quotient = quotient + multiple;
        }

        
        if (negative) {
            quotient = -quotient;
        }

       
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }
    public static void main(String args[]){
        LP29 obj = new LP29();
         int dividend = 10;
         int  divisor = 3;
         System.out.println(obj.divide(dividend,divisor));

    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(log^2(dividend))` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
