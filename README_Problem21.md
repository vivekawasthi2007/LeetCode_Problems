# 🧩 Problem 21: Merge Two Sorted Lists

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_21-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/merge-two-sorted-lists/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-brightgreen)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Merge two sorted linked lists into one sorted list and return its head.

🔗 **LeetCode Link:** [Merge Two Sorted Lists - LeetCode](https://leetcode.com/problems/merge-two-sorted-lists/)

---

## 🏷️ Topics
`Linked List` `Recursion`

---

## 💡 Examples
**Input:** list1 = [1,2,4], list2 = [1,3,4]
**Output:** [1,1,2,3,4,4]

---

## 🧠 Intuition & Approach
1. Initialize a `dummy` node and `current` pointer.
2. Compare heads of `list1` and `list2`; attach smaller node to `current.next`.
3. Advance pointer of chosen list and `current`.
4. Attach remaining nodes from non-empty list and return `dummy.next`.

---

## 💻 Java Solution ([LeetCode_Problem21.java](LeetCode_Problem21.java))

```java
class Main {

    // ListNode class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Your original solution
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } 
            else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } 
        else {
            current.next = list2;
        }

        return dummy.next;
    }

    // Print linked list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        // List 1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // List 2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Merge
        ListNode result = mergeTwoLists(list1, list2);

        // Print
        System.out.print("Result: ");
        printList(result);
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(n + m)` |
| **Space Complexity** | `O(1)` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
