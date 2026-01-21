import java.util.ArrayList;
import java.util.Stack;

//import java.util.*;
public class TwentyOneJanuary {
//    static class Node {
//        int data;
//        Node next;
//
//        Node(int data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    static class Stack1 {
//        static Node head = null;
//
//        public static boolean isEmpty() {
//            return head == null;
//        }
//
//        public static void push(int data) {
//            Node newNode = new Node(data);
//            if (isEmpty()) {
//                head = newNode;
//                return;
//            }
//            newNode.next = head;
//            head = newNode;
//        }
//
//        public static int pop() {
//            if (isEmpty()) {
//                return -1;
//            }
//            int top = head.data;
//            head = head.next;
//            return top;
//        }
//
//        public static int peek() {
//            if (isEmpty()) {
//                return -1;
//            }
//            return head.data;
//        }
//    }
//
//    static class Stack {
//        static ArrayList<Integer> list = new ArrayList<>();
//
//        public static boolean isEmpty() {
//            return list.size() == 0;
//        }
//
//        public static void push(int data) {
//            list.add(data);
//        }
//
//        public static int pop() {
//            if (isEmpty()) {
//                return -1;
//            }
//            int top = list.get(list.size() - 1);
//            list.remove(list.size() - 1);
//            return top;
//        }
//
//        public static int peek() {
//            if (isEmpty()) {
//                return -1;
//            }
//            return list.get(list.size() - 1);
//        }
//    }

    private static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }

    public static String reverseString(String str) {
        Stack<Character> stk = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            stk.push(str.charAt(idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder("");
        while (!stk.isEmpty()) {
            char top = stk.pop();
            sb.append(top);
        }
        return new String(sb);
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
//            stack.pop();
        }
    }

    public static void main(String[] args) {
//        Stack s = new Stack();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//
//        while (!s.isEmpty()) {
//            System.out.println(s.peek());
//            s.pop();
//        }
//        System.out.println("LinkedList");
//        Stack1 s1 = new Stack1();
//        s1.push(1);
//        s1.push(2);
//        s1.push(3);
//
//        while (!s1.isEmpty()) {
//            System.out.println(s1.peek());
//            s1.pop();
//        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

//        pushAtBottom(stack, 4);
//
//        while (!stack.isEmpty()) {
//            System.out.println(stack.peek());
//            stack.pop();
//        }

        System.out.println(reverseString("vishesh"));

//        printStack(stack);
        reverseStack(stack);
        printStack(stack);
    }

}
