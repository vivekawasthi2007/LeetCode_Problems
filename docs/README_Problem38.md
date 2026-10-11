# 🧩 Problem 38: Count and Say

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_38-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/count-and-say/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
- `countAndSay(1) = "1"`
- `countAndSay(n)` is the run-length encoding of `countAndSay(n - 1)`.

Given an integer `n`, return the `n`-th element of the count-and-say sequence.

🔗 **LeetCode Link:** [Count and Say - LeetCode](https://leetcode.com/problems/count-and-say/)

---

## 🏷️ Topics
`String`

---

## 💡 Examples
**Input:** n = 4
**Output:** "1211"
**Explanation:**
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1s = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "1211"

---

## 🧠 Intuition & Approach
1. Start with base sequence string `result = "1"`.
2. Perform `n - 1` iterations to build up to the `n`-th sequence element.
3. In each iteration, iterate through the current string and count consecutive identical characters.
4. Whenever the character changes or the string ends, append the run length count followed by the character to a `StringBuilder`.
5. Update `result` with the newly built string and repeat.

---

## 💻 Java Solution ([LeetCode_Problem38.java](../LeetCode_Problem38.java))

```java
class LP38 {
   static  String countAndSay(int n) {

        String result = "1";

        for (int i = 1; i < n; i++) {

            StringBuilder next = new StringBuilder();

            int count = 1;

            for (int j = 1; j < result.length(); j++) {

                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    next.append(count);
                    next.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            next.append(count);
            next.append(result.charAt(result.length() - 1));

            result = next.toString();
        }

        return result;
    }
    public static void main(String args[]){
        int n = 4;
        System.out.println(countAndSay(n));
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(2^n)` |
| **Space Complexity** | `O(2^n)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
