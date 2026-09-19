# Problem 744: LeetCode Problem 744

- **LeetCode:** [Problem 744 - LeetCode Problem 744](https://leetcode.com/problemset/)
- **Difficulty:** 
- **Topics:** 

## Problem Statement

Given a sorted array of lowercase letters and a target letter, find the smallest letter in the array that is strictly greater than the target.

If no letter is greater than the target, return the first letter in the array by wrapping around to the beginning.

## Example

**Input:**

```text
letters = ['c', 'f', 'j']
target = 'a'
```

**Output:**

```text
'c'
```

The letter `'c'` is the smallest letter in the array that is greater than `'a'`.

## Approach

The submitted code uses binary search because the `letters` array is sorted.

The search looks for the first letter that is strictly greater than `target`:

- If `letters[mid]` is less than or equal to `target`, the answer must be to the right.
- Otherwise, `letters[mid]` may be the answer, so the search continues on the left side.
- After the loop, `start` points to the first letter greater than `target`.
- The expression `start % letters.length` handles the wraparound case when no letter is greater than `target`.

## Step-by-Step Explanation

1. `start` is initialized to `0`, and `end` is initialized to the last index of the array.
2. The `while` loop continues while `start <= end`.
3. `mid` is calculated as the middle index:
   ```java
   int mid = start + (end - start) / 2;
   ```
4. If `letters[mid] <= target`, the current letter cannot be the answer because the answer must be strictly greater. The search moves right:
   ```java
   start = mid + 1;
   ```
5. Otherwise, `letters[mid]` is greater than the target, so it could be the answer. The search moves left to find a smaller valid letter:
   ```java
   end = mid - 1;
   ```
6. When the loop ends, `start` is the index of the first letter greater than `target`.
7. The result is returned using:
   ```java
   letters[start % letters.length]
   ```
   If `start` equals `letters.length`, the modulo operation changes it to `0`, which correctly wraps around to the first letter.

## Java Solution

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

## Complexity

- **Time Complexity:** `O(log n)` because binary search repeatedly halves the search range.
- **Space Complexity:** `O(1)` because the algorithm uses only a fixed number of variables.

## Key Learning

- Binary search can efficiently find a position in a sorted array.
- Moving left after finding a valid value helps locate the smallest valid answer.
- The modulo operator can be used to implement circular wraparound.
- Comparisons with `<=` are important when the answer must be strictly greater than the target.
