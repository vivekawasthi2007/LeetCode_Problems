# 🧩 Problem 12: Integer to Roman

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_12-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/integer-to-roman/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Convert a given integer `num` into a Roman numeral representation.

🔗 **LeetCode Link:** [Integer to Roman - LeetCode](https://leetcode.com/problems/integer-to-roman/)

---

## 🏷️ Topics
`Hash Table` `Math` `String`

---

## 💡 Examples
**Input:** num = 3749
**Output:** "MMMDCCXLIX"

---

## 🧠 Intuition & Approach
1. Define descending integer values `[1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]` and matching Roman symbols.
2. Greedily subtract value while `num >= val[i]` and append Roman symbol to `StringBuilder`.
3. Return result.

---

## 💻 Java Solution ([LeetCode_Problem12.java](../LeetCode_Problem12.java))

```java
class LP12 {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<values.length;i++){
            while(num>=values[i]){
                sb.append(symbol[i]);
                num  = num - values[i];
            }
        }
        return sb.toString();

    }
    public static void main(String args[]){
        LP12 obj1 = new LP12();
        int num = 3343;
        String ans = obj1.intToRoman(num);
        System.out.println(ans);
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(1)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
