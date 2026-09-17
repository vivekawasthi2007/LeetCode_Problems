# 🧩 Problem 1672: Richest Customer Wealth

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_1672-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/richest-customer-wealth/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Return the wealth of the richest customer, where wealth is the sum of money in all their bank accounts.

🔗 **LeetCode Link:** [Richest Customer Wealth - LeetCode](https://leetcode.com/problems/richest-customer-wealth/)

---

## 🏷️ Topics
`Array` `Matrix`

---

## 💡 Examples
**Input:** accounts = [[1,2,3],[3,2,1]]
**Output:** 6

---

## 🧠 Intuition & Approach
1. Iterate through each customer row in `accounts`.
2. Sum elements of row `sum(accounts[i])`.
3. Track maximum wealth seen: `maxWealth = Math.max(maxWealth, rowSum)`.
4. Return `maxWealth`.

---

## 💻 Java Solution ([LeetCode_Problem1672.java](../LeetCode_Problem1672.java))

```java
class LP1672 {
    public int maximumWealth(int[][] accounts) {
        int ans  = Integer.MIN_VALUE;
        for(int i = 0; i<accounts.length;i++){
            int sum = 0;
            for(int j = 0; j<accounts[i].length;j++){
               sum += accounts[i][j];
               
            }
            if(sum>ans){
                 ans = sum;
               }
            
        }
        return ans;
    }
    public static void main(String args[]){
        LP1672 obj = new LP1672();
        int[][] accounts = {{1,3,6},{2,3,3},{1,2,3,4}};
        int answer = obj.maximumWealth(accounts);
        System.out.println(answer);
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(m * n)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
