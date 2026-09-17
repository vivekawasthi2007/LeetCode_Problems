# 🧩 Problem 16: 3Sum Closest

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_16-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/3sum-closest/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given an integer array `nums` and `target`, find three integers in `nums` whose sum is closest to `target`.

🔗 **LeetCode Link:** [3Sum Closest - LeetCode](https://leetcode.com/problems/3sum-closest/)

---

## 🏷️ Topics
`Array` `Two Pointers` `Sorting`

---

## 💡 Examples
**Input:** nums = [-1,2,1,-4], target = 1
**Output:** 2

---

## 🧠 Intuition & Approach
1. Sort the array.
2. Initialize `closestSum = nums[0] + nums[1] + nums[2]`.
3. For each index `i`, run two pointers `left = i + 1`, `right = n - 1`.
4. If `Math.abs(currSum - target) < Math.abs(closestSum - target)`, update `closestSum`.
5. Adjust `left++` or `right--` based on comparison with `target`.

---

## 💻 Java Solution ([LeetCode_Problem16.java](../LeetCode_Problem16.java))

```java
import java.util.Arrays;
class LP16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0;i<nums.length - 2;i++){
            int left = i + 1;
            int right = nums.length - 1;

            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return sum;
                }
                else if(Math.abs(sum - target)< Math.abs(closestSum - target)){
                    closestSum = sum;
                }
                else if(sum<target){
                    left++;
                }
                else{
                    right--;
                }
            }     

        


        }
      return closestSum;  
    }
    public static void main(String args[]){
        LP16 obj1 = new LP16();
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int ans = obj1.threeSumClosest( nums, target);
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
