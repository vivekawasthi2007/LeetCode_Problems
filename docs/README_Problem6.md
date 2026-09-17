# 🧩 Problem 6: Zigzag Conversion

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_6-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/zigzag-conversion/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows, then read line by line. Convert the string accordingly.

🔗 **LeetCode Link:** [Zigzag Conversion - LeetCode](https://leetcode.com/problems/zigzag-conversion/)

---

## 🏷️ Topics
`String` `Simulation`

---

## 💡 Examples
**Input:** s = "PAYPALISHIRING", numRows = 3
**Output:** "PAHNAPLSIIGYIR"

---

## 🧠 Intuition & Approach
1. Edge case: If `numRows == 1` or `numRows >= s.length()`, return `s`.
2. Create an array of `StringBuilder` of length `numRows`.
3. Iterate over characters, tracking current row and a boolean direction flag `down`.
4. Reverse direction at row 0 and row `numRows - 1`.
5. Concatenate all rows into the final result.

---

## 💻 Java Solution ([LeetCode_Problem6.java](../LeetCode_Problem6.java))

```java
class LP6 {
    public String convert(String s, int numRows) {
        if(numRows ==1 || numRows>=s.length()){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i<numRows;i++){
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean down = true;

        for(int i = 0;i<s.length();i++){
            rows[row].append(s.charAt(i));

            if(row == numRows - 1){
                down = false;
            }
            if(row ==0){
                down = true;
            }
            if(down){
                row++;
            }else{
                row--;
            }
        } 
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<numRows;i++){
            ans.append(rows[i]);
        }
        return ans.toString();
    }
    public static void main(String args[]){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        LP6 obj1 = new LP6();
        String ans = obj1.convert(s,numRows);
        System.out.println(ans);
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(n)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
