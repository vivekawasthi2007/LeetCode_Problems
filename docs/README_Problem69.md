# 🧩 Problem 69: Sqrt(x)

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_69-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/sqrtx/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a non-negative integer `x`, return the square root of `x` rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

🔗 **LeetCode Link:** [Sqrt(x) - LeetCode](https://leetcode.com/problems/sqrtx/)

---

## 🏷️ Topics
`Math` `Binary Search`

---

## 💡 Examples
**Input:** x = 4
**Output:** 2
**Explanation:** The square root of 4 is 2, so we return 2.

**Input:** x = 8
**Output:** 2
**Explanation:** The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

---

## 🧠 Intuition & Approach
1. If `x < 2`, return `x` directly.
2. Use binary search over range `[1, x / 2]` with `start = 1` and `end = x / 2`.
3. Calculate `mid = start + (end - start) / 2` and `square = (long)mid * mid` to avoid integer overflow.
4. If `square == x`, return `mid` directly.
5. If `square < x`, move `start = mid + 1` to search for larger candidates.
6. If `square > x`, move `end = mid - 1` to search smaller candidates.
7. When the search ends, `end` represents the largest integer whose square is `<= x`.

---

## 💻 Java Solution ([LeetCode_Problem69.java](../LeetCode_Problem69.java))

```java
class LP69 {
    static int mySqrt(int x) {
        if(x<2){
            return x;
        }
        int start = 1;
        int end = x/2;
        while(start <= end){
            int mid = start+(end - start)/2;
            
            long square = (long)mid*mid;

            if(square == x){
                return mid;
            }
            else if(square<x){
                start = mid +1;
            }else{
                end = mid - 1;
            }
        }
        return end;
    }
     public static void main(String args[]){
       int k = 8;
      
        System.out.println(mySqrt(k));
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(log x)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
