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