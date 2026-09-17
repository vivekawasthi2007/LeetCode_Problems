# 🧩 Problem 11: Container With Most Water

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_11-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/container-with-most-water/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an integer array `height` of length `n`, find two lines that together with the x-axis form a container that stores the maximum amount of water.

🔗 **LeetCode Link:** [Container With Most Water - LeetCode](https://leetcode.com/problems/container-with-most-water/)

---

## 🏷️ Topics
`Array` `Two Pointers` `Greedy`

---

## 💡 Examples
**Input:** height = [1,8,6,2,5,4,8,3,7]
**Output:** 49

---

## 🧠 Intuition & Approach
1. Place pointers at both ends: `left = 0` and `right = n - 1`.
2. Calculate current area: `Math.min(height[left], height[right]) * (right - left)`.
3. Update `maxArea`.
4. Move the pointer pointing to the shorter vertical bar inward.

---

## 💻 Java Solution ([LeetCode_Problem11.java](LeetCode_Problem11.java))

```java
class Solution{
      public static void main(String args[])
      {
        int[] height = {1,8,6,2,5,4,8,3,7};
        Solution solu = new Solution();
        int result = solu.maxArea(height);
        System.out.println(result);
      }
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int currArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currArea);

            if(height[left]< height[right])
            { 
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
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
