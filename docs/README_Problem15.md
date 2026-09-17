# 🧩 Problem 15: 3Sum

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_15-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/3sum/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an integer array `nums`, return all unique triplets `[nums[i], nums[j], nums[k]]` such that `nums[i] + nums[j] + nums[k] == 0`.

🔗 **LeetCode Link:** [3Sum - LeetCode](https://leetcode.com/problems/3sum/)

---

## 🏷️ Topics
`Array` `Two Pointers` `Sorting`

---

## 💡 Examples
**Input:** nums = [-1,0,1,2,-1,-4]
**Output:** [[-1,-1,2],[-1,0,1]]

---

## 🧠 Intuition & Approach
1. Sort `nums` in ascending order.
2. Fix first element `nums[i]`; skip duplicate `nums[i]` values.
3. Use two pointers `left = i + 1` and `right = n - 1`.
4. If sum == 0, add triplet and skip duplicates for `left` and `right`.
5. If sum < 0, `left++`; else `right--`.

---

## 💻 Java Solution ([LeetCode_Problem15.java](../LeetCode_Problem15.java))

```java
import java.util.*;
class LP15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0;i<nums.length - 2;i++){
            if(i>0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
public static void main(String args[]){
    LP15 obj1 = new LP15();
    int[] nums = {-1,0,-1,2,1,-4};
    List<List<Integer>> ans = obj1.threeSum(nums);
    System.out.println(ans);
}
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n^2)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
