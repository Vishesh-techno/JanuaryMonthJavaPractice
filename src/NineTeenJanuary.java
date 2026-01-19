public class NineTeenJanuary {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode head;

    public static void add(int val) {
        ListNode temp = head;
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "==>");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            first.next = second.next;
            second.next = first;
            p.next = second;
            p = first;
            head = first.next;
        }
        return dummy.next;
    }

    public static void swapNodeHelper(ListNode prev, ListNode curr) {
        if (curr == null || curr.next == null) {
            return;
        }
        ListNode first = curr,
                second = curr.next;
        first.next = second.next;
        second.next = first;
        prev.next = second;

        swapNodeHelper(first, first.next);
    }

    public static ListNode swapPairsII(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        swapNodeHelper(p, head);
        return dummy.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null,
                curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseListII(ListNode head) {
        return reverseHelper(null, head);
    }

    private static ListNode reverseHelper(ListNode prev, ListNode curr) {
        if (curr == null) {
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;

        return reverseHelper(prev, curr);
    }

    public static void main(String[] args) {
        add(6);
        add(5);
        add(4);
        add(3);
        add(2);
        add(1);
        printList();
        head = swapPairs(head);
        printList();
        head = swapPairsII(head);
        printList();
        head = reverseList(head);
        printList();
        head = reverseListII(head);
        printList();
    }
}

