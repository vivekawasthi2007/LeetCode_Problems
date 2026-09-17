# 🧩 Problem 2: Add Two Numbers

[![LeetCode](https://img.shields.io/badge/LeetCode-Problem_2-FFA116?logo=leetcode&logoColor=black)](https://leetcode.com/problems/add-two-numbers/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange)](#)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](#)

## 📌 Problem Statement
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

🔗 **LeetCode Link:** [Add Two Numbers - LeetCode](https://leetcode.com/problems/add-two-numbers/)

---

## 🏷️ Topics
`Linked List` `Math` `Recursion`

---

## 💡 Examples
**Input:** l1 = [2,4,3], l2 = [5,6,4]
**Output:** [7,0,8]
**Explanation:** 342 + 465 = 807.

---

## 🧠 Intuition & Approach
1. Initialize a `dummy` node and a `current` pointer.
2. Traverse both linked lists while `l1 != null`, `l2 != null`, or `carry != 0`.
3. Extract node values, compute `sum = x + y + carry`.
4. Update `carry = sum / 10` and append a new `ListNode(sum % 10)` to `current.next`.
5. Advance pointers and return `dummy.next`.

---

## 💻 Java Solution ([LeetCode_Problem2.java](../LeetCode_Problem2.java))

```java
class Main {

    // Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;
            int digit = sum % 10;

            current.next = new ListNode(digit);
            current = current.next;

            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        return dummy.next;
    }

    // Print Linked List
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null)
                System.out.print(" -> ");

            head = head.next;
        }
    }

    public static void main(String[] args) {

        // 2 -> 4 -> 3 = 342
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 5 -> 6 -> 4 = 465
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        printList(result);
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity |
|---|---|
| **Time Complexity** | `O(max(m, n))` |
| **Space Complexity** | `O(max(m, n))` |

---

### 👨‍💻 Author
Solved by **[Vivek Awasthi](https://github.com/vivekawasthi2007)**
