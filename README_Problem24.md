# 🧩 Problem 24: Swap Nodes in Pairs

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_24-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/swap-nodes-in-pairs/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
Given a linked list, swap every two adjacent nodes and return its head in-place without modifying node values.

🔗 **LeetCode Link:** [Swap Nodes in Pairs - LeetCode](https://leetcode.com/problems/swap-nodes-in-pairs/)

---

## 🏷️ Topics
`Linked List` `Recursion`

---

## 💡 Examples
**Input:** head = [1,2,3,4]
**Output:** [2,1,4,3]

---

## 🧠 Intuition & Approach
1. Initialize `dummy` pointing to `head` and `prev = dummy`.
2. While `prev.next != null && prev.next.next != null`:
   - `first = prev.next`, `second = prev.next.next`
   - `prev.next = second`
   - `first.next = second.next`
   - `second.next = first`
   - `prev = first`

---

## 💻 Java Solution ([LeetCode _Problem24.java](LeetCode _Problem24.java))

```java
class LP24 {

    // Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Swap every two adjacent nodes
    public static ListNode swapPairs(ListNode head) {

        // 0 ya 1 node hai to swap ki zarurat nahi
        if (head == null || head.next == null) {
            return head;
        }

        // First two nodes
        ListNode first = head;
        ListNode second = head.next;

        // Remaining list ko swap karo
        first.next = swapPairs(second.next);

        // Second ko first ke pehle lagao
        second.next = first;

        // Second new head banega
        return second;
    }

    // Print Linked List
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

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Before swapping:");
        printList(head);

        // Swap nodes
        head = swapPairs(head);

        System.out.println("After swapping:");
        printList(head);
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
