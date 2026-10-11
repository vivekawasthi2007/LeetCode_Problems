# 🧩 Problem 40: Combination Sum II

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_40-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/combination-sum-ii/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum to `target`.

Each number in `candidates` may only be used once in the combination. The solution set must not contain duplicate combinations.

🔗 **LeetCode Link:** [Combination Sum II - LeetCode](https://leetcode.com/problems/combination-sum-ii/)

---

## 🏷️ Topics
`Array` `Backtracking`

---

## 💡 Examples
**Input:** candidates = [10,1,2,7,6,1,5], target = 8
**Output:** [[1,1,6],[1,2,5],[1,7],[2,6]]

---

## 🧠 Intuition & Approach
1. Sort the array `candidates` first to place duplicate elements adjacent to each other.
2. Use backtracking with an index pointer `start`.
3. At each depth, skip duplicate elements (`if (i > start && candidates[i] == candidates[i - 1]) continue`) to avoid generating duplicate combination sets.
4. If `candidates[i] > target`, break early because the array is sorted.
5. Advance the start index to `i + 1` in the recursive call so each element is used at most once.
6. Backtrack by popping the last element from `current`.

---

## 💻 Java Solution ([LeetCode_Problem40.java](../LeetCode_Problem40.java))

```java
import java.util.*;

class LP40 {
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    static void backtrack(int[] candidates, int target, int start,
                           List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);

            backtrack(candidates, target - candidates[i], i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
    public static void main(String args[]){
       int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));

    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(2^n)` |
| **Space Complexity** | `O(n)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
