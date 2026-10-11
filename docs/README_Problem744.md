# 🧩 Problem 744: Find Smallest Letter Greater Than Target

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_744-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
You are given an array of characters `letters` that is sorted in non-decreasing order, and a character `target`. There are at least two different characters in `letters`.

Return the smallest character in `letters` that is lexicographically greater than `target`. If such a character does not exist, return the first character in `letters`.

🔗 **LeetCode Link:** [Find Smallest Letter Greater Than Target - LeetCode](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)

---

## 🏷️ Topics
`Array` `Binary Search`

---

## 💡 Examples
**Input:** letters = ["c","f","j"], target = "a"
**Output:** "c"
**Explanation:** The smallest character that is lexicographically greater than 'a' in letters is 'c'.

**Input:** letters = ["c","f","j"], target = "c"
**Output:** "f"
**Explanation:** The smallest character that is lexicographically greater than 'c' in letters is 'f'.

**Input:** letters = ["x","x","y","y"], target = "z"
**Output:** "x"
**Explanation:** There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].

---

## 🧠 Intuition & Approach
1. Use binary search over the sorted characters array with `start = 0` and `end = letters.length - 1`.
2. If `letters[mid] <= target`, the answer must lie to the right, so `start = mid + 1`.
3. If `letters[mid] > target`, `letters[mid]` could be the answer, so look for smaller candidates on the left: `end = mid - 1`.
4. After binary search completes, `start` points to the first character greater than `target`.
5. Use modulo indexing `letters[start % letters.length]` to wrap around to index `0` if `target` is greater than or equal to all elements.

---

## 💻 Java Solution ([LeetCode_Problem744.java](../LeetCode_Problem744.java))

```java
class LP744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        while(start<=end){
            int mid = start +(end-start)/2;

            if(letters[mid]<=target){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return letters[start % letters.length];
    }
    public static void main(String args[]){
        LP744 obj = new LP744();
        char[] letters = {'c','f','j'};
        char target = 'a';
        System.out.println(obj.nextGreatestLetter(letters,target));
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(log n)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
