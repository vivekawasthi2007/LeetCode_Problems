# 🧩 Problem 7: Reverse Integer

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_7-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/reverse-integer/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a signed 32-bit integer `x`, return `x` with its digits reversed. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, return 0.

🔗 **LeetCode Link:** [Reverse Integer - LeetCode](https://leetcode.com/problems/reverse-integer/)

---

## 🏷️ Topics
`Math`

---

## 💡 Examples
**Input:** x = 123 -> **Output:** 321
**Input:** x = -123 -> **Output:** -321

---

## 🧠 Intuition & Approach
1. Extract digits using `digit = x % 10` and reduce `x = x / 10`.
2. Before multiplying `rev * 10`, check for overflow against `Integer.MAX_VALUE / 10` and `Integer.MIN_VALUE / 10`.
3. If overflow would occur, return 0 immediately.
4. Otherwise update `rev = rev * 10 + digit`.

---

## 💻 Java Solution ([LeetCode_Problem7.java](../LeetCode_Problem7.java))

```java
class LP7 {
    public int reverse(int x) {
        int rev = 0;
        while(x!=0){
            int digit = x % 10;
            x = x/10;
            if(rev > Integer.MAX_VALUE/10 ||(rev ==Integer.MAX_VALUE/10 && digit >7)){
                return 0;
            }
            if(rev < Integer.MIN_VALUE/10 ||(rev ==Integer.MIN_VALUE/10 && digit <-8)){
                return 0;
            }
            rev = rev*10+digit;
        }
        return rev;
    }
    public static void main(String args[]){
        LP7 obj1 = new LP7();
        int x = 123;
        int ans = obj1.reverse(x);
        System.out.println(ans);
        
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(log10(x))` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
