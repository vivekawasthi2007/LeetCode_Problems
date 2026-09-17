# 🧩 Problem 36: Valid Sudoku

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_36-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/valid-sudoku/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Determine if a 9 x 9 Sudoku board is valid by checking rows, columns, and 3x3 sub-boxes without duplicates.

🔗 **LeetCode Link:** [Valid Sudoku - LeetCode](https://leetcode.com/problems/valid-sudoku/)

---

## 🏷️ Topics
`Array` `Hash Table` `Matrix`

---

## 💡 Examples
**Input:** 9x9 board
**Output:** true / false

---

## 🧠 Intuition & Approach
1. Iterate through all cells `(r, c)` in the 9x9 board.
2. Track seen digits using boolean arrays or HashSets for rows, columns, and sub-boxes.
3. Calculate box index: `(r / 3) * 3 + (c / 3)`.
4. If duplicate digit found in row, col, or box, return `false`. Otherwise `true`.

---

## 💻 Java Solution ([LeetCode_Problem36.java](LeetCode_Problem36.java))

```java
class Solution {

    public static boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '1';

                int boxIndex = (i / 3) * 3 + (j / 3);

                if (row[i][num] || col[j][num] || box[boxIndex][num]) {
                    return false;
                }

                row[i][num] = true;
                col[j][num] = true;
                box[boxIndex][num] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));
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
