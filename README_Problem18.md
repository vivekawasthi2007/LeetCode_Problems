# 🧩 Problem 18: 4Sum

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_18-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/4sum/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an array `nums` of `n` integers and an integer `target`, return all unique quadruplets `[nums[a], nums[b], nums[c], nums[d]]` that sum to `target`.

🔗 **LeetCode Link:** [4Sum - LeetCode](https://leetcode.com/problems/4sum/)

---

## 🏷️ Topics
`Array` `Two Pointers` `Sorting`

---

## 💡 Examples
**Input:** nums = [1,0,-1,0,-2,2], target = 0
**Output:** [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

---

## 🧠 Intuition & Approach
1. Sort the array.
2. Use two nested loops for the first two elements (`i` and `j`), skipping duplicates.
3. Use two pointers (`left` and `right`) for the remaining two elements.
4. Use `long` arithmetic to prevent integer overflow.

---

## 💻 Java Solution ([LeetCode_Problem18.java](LeetCode_Problem18.java))

```java
import java.util.*;
class LP18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // IMPORTANT: left starts after j
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    long sum = (long) nums[i]
                             + nums[j]
                             + nums[left]
                             + nums[right];

                    if (sum == target) {

                        result.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[left],
                            nums[right]
                        ));

                        left++;
                        right--;

                        while (left < right &&
                               nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right &&
                               nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } 
                    else if (sum < target) {
                        left++;
                    } 
                    else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
    public static void main(String args[]){
        LP18 obj1 = new LP18();
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = obj1.fourSum(nums, target);
        System.out.println(ans);

    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n^3)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
