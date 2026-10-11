# 🧩 Problem 39: Combination Sum

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_39-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/combination-sum/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an array of distinct integers `candidates` and a target integer `target`, return a list of all unique combinations of `candidates` where the chosen numbers sum to `target`. You may return the combinations in any order.

The same number may be chosen from `candidates` an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

🔗 **LeetCode Link:** [Combination Sum - LeetCode](https://leetcode.com/problems/combination-sum/)

---

## 🏷️ Topics
`Array` `Backtracking`

---

## 💡 Examples
**Input:** candidates = [2,3,6,7], target = 7
**Output:** [[2,2,3],[7]]
**Explanation:**
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

---

## 🧠 Intuition & Approach
1. Use recursive backtracking to explore candidate combinations.
2. If `target == 0`, a valid combination is found; add a copy of `current` to `result`.
3. Iterate through candidates starting from index `start`: if `candidates[i] > target`, skip it.
4. Add `candidates[i]` to `current`, then recursively call `backtrack` with `target - candidates[i]` and the same index `i` (enabling unlimited reuse).
5. Backtrack by removing the last element added to explore other paths.

---

## 💻 Java Solution ([LeetCode_Problem39.java](../LeetCode_Problem39.java))

```java
import java.util.*;
class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        
        return result;
    }

    static void backtrack(int[] candidates, int target, int start,
                            List<Integer> current,
                            List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target) {
                continue;
            }

            current.add(candidates[i]);

            backtrack(candidates,
                      target - candidates[i],
                      i,
                      current,
                      result);

            current.remove(current.size() - 1);
        }
    }
    public static void main(String args[]){
         int[] candidates = {2,3,6,7};
         int target = 7;
         System.out.println(combinationSum(candidates,target));
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(2^(target / min))` |
| **Space Complexity** | `O(target / min)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
