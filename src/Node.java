import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
    }

    static Node head;

    public static void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("null");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "==>>");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

class solution {
    public static boolean removeLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

//                if loop start from head
                if (slow == head) {
                    while (fast.next != head) {
                        fast = fast.next;
                    }
                    fast.next = null;
                    return true;
                }

                slow = head;
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] arr = sc.nextLine().split(" ");
        for (String s : arr) {
            Node.addNode(Integer.parseInt(s));
        }

        System.out.print("Enter Position index for a Loop: ");
        int pos = sc.nextInt();

        if (pos != -1) {
            Node temp = Node.head;
            Node loopNode = null;
            int idx = 0;

            while (temp.next != null) {
                if (idx == pos) loopNode = temp;
                temp = temp.next;
                idx++;
            }
            temp.next = loopNode;
        }

        boolean result = removeLoop(Node.head);
        System.out.println("Loop Removed: " + result);
        Node.print();
    }
}
