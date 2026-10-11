# 🧩 Problem 1111: Maximum Nesting Depth of Two Valid Parentheses Strings

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_1111-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
A valid parentheses string `seq` can be split into two disjoint subsequences `A` and `B` (which are also valid parentheses strings). Choose `A` and `B` such that `max(depth(A), depth(B))` is the minimum possible.

Return an answer array of length `seq.length` with `0` for characters assigned to `A` and `1` for characters assigned to `B`.

🔗 **LeetCode Link:** [Maximum Nesting Depth of Two Valid Parentheses Strings - LeetCode](https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/)

---

## 🏷️ Topics
`String` `Stack` `Greedy`

---

## 💡 Examples
**Input:** seq = "(()())"
**Output:** [0,1,1,1,1,0]

**Input:** seq = "()(())()"
**Output:** [0,0,0,1,1,0,0,0]

---

## 🧠 Intuition & Approach
1. To minimize the maximum nesting depth between groups A and B, evenly distribute the nesting depth across both groups.
2. Track the current nesting depth with a counter `depth`.
3. When encountering `'('`: increment `depth++` and assign group using depth parity `depth % 2`.
4. When encountering `')'`: assign group using depth parity `depth % 2`, then decrement `depth--`.
5. This partitions alternating layers of parentheses between groups 0 and 1, ensuring maximum depth is halved.

---

## 💻 Java Solution ([LeetCode_Problem1111.java](../LeetCode_Problem1111.java))

```java
import java.util.Arrays;
class LP1111 {
    static int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                depth++;
                ans[i] = depth % 2;
            } else {
                ans[i] = depth % 2;
                depth--;
            }
        }

        return ans;
    }
    public static void main(String args[]){
        String seq =  "()(())()";
        int[] ans = maxDepthAfterSplit(seq);
        System.out.println(Arrays.toString(ans));
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
