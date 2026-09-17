# 🧩 Problem 31: Next Permutation

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_31-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/next-permutation/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Rearrange numbers into the lexicographically next greater permutation in-place.

🔗 **LeetCode Link:** [Next Permutation - LeetCode](https://leetcode.com/problems/next-permutation/)

---

## 🏷️ Topics
`Array` `Two Pointers`

---

## 💡 Examples
**Input:** nums = [1,2,3] -> **Output:** [1,3,2]
**Input:** nums = [3,2,1] -> **Output:** [1,2,3]

---

## 🧠 Intuition & Approach
1. Find pivot from right where `nums[i] < nums[i + 1]`.
2. If not found, reverse entire array.
3. If found, find successor `nums[j] > nums[i]` from right, swap `nums[i]` and `nums[j]`.
4. Reverse subarray from `i + 1` to `n - 1`.

---

## 💻 Java Solution ([LeetCode_Problem31.java](LeetCode_Problem31.java))

```java
import java.util.Arrays;
class LP31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = nums.length - 1;
            while( nums[j]<= nums[i]){
                j--;
            }
           swap(nums,i,j);
        
         }
        reverse(nums,i+1,nums.length-1);
    }
        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        public void reverse(int[] nums,int start,int end){
            while(start<end){
                swap(nums,start,end);
                start++;
                end--;

                
            }
        }
  
    public static void main(String[] args){
        int[] nums = {1,2,3};
        LP31 obj1 = new LP31();
        obj1.nextPermutation(nums);
      
        System.out.print(Arrays.toString(nums));
        
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
