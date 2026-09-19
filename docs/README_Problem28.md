# Problem 28: LeetCode Problem 28

- **LeetCode:** [Problem 28 - LeetCode Problem 28](https://leetcode.com/problemset/)
- **Difficulty:** 
- **Topics:** 

## Problem Statement

Given two strings, `haystack` and `needle`, find the index of the first occurrence of `needle` within `haystack`.

Return the starting index of the first matching occurrence. If `needle` does not appear in `haystack`, return `-1`.

## Example

**Input:**

```text
haystack = "sadbutsad"
needle = "sad"
```

**Output:**

```text
0
```

The substring `"sad"` first appears in `haystack` starting at index `0`.

## Approach

The code uses a straightforward brute-force substring search.

It checks every possible starting position in `haystack`. For each position, it compares the characters in `haystack` with the characters in `needle` one by one.

- If all characters match, the current starting index is returned.
- If a mismatch occurs, the code moves to the next possible starting position.
- If no match is found, the method returns `-1`.

## Step-by-Step Explanation

1. Store the lengths of the two strings:
   - `n` is the length of `haystack`.
   - `m` is the length of `needle`.

2. Use a `for` loop to check each possible starting index `i` in `haystack`.

3. The loop continues while `i <= n - m`, ensuring that enough characters remain in `haystack` to compare with `needle`.

4. Set `j` to `0`. This variable tracks the current character being compared in `needle`.

5. The `while` loop compares:
   - `haystack.charAt(i + j)`
   - `needle.charAt(j)`

   The comparison continues while the characters match and `j` is less than `m`.

6. If all characters match, `j` becomes equal to `m`. The condition `j == m` is then true, so the method returns `i`.

7. If no starting position produces a complete match, the method returns `-1`.

8. The `main` method creates an `LP28` object, searches for `"sad"` in `"sadbutsad"`, and prints the result.

## Java Solution

```java
class LP28 {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }
    public static void main(String args[]){
        LP28 obj = new LP28();
        String haystack = "sadbutsad";
        String needle = "sad";
        int ans = obj.strStr(haystack, needle);
        System.out.println(ans);

    }
}
```

## Complexity

- **Time Complexity:** `O((n - m + 1) * m)` in the worst case, commonly expressed as `O(n * m)`, where `n` is the length of `haystack` and `m` is the length of `needle`.
- **Space Complexity:** `O(1)` because the algorithm uses only a few variables and does not allocate additional data structures.

## Key Learning

- Brute-force substring searching checks each possible starting position.
- Nested loops can be used to compare two strings character by character.
- Loop bounds can prevent unnecessary comparisons when the remaining portion is too short.
- Returning as soon as a match is found avoids extra work.
