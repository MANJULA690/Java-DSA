import java.util.*;

public class StackB {

    // static class Node {
    // int data;
    // Node next;

    // Node(int data) {
    // this.data = data;
    // this.next = null;
    // }
    // }

    // static class Stack {
    // stack implementaion with AL
    // static ArrayList<Integer> list = new ArrayList<>();

    // public static boolean isEmpty() {
    // return list.size() == 0;
    // }

    // public static void push(int data) {
    // list.add(data);
    // }

    // public static int pop() {
    // if (isEmpty()) {
    // return -1;
    // }
    // int val = list.get(list.size() - 1);
    // list.remove(list.size() - 1);
    // return val;
    // }

    // public static int peek() {
    // if (isEmpty()) {
    // return -1;
    // }
    // return list.get(list.size() - 1);
    // }

    // stack implementaion with LL
    // static Node head = null;

    // public static boolean isEmpty() {
    // return head == null;
    // }

    // public static void push(int data) {
    // Node newNode = new Node(data);
    // if (isEmpty()) {
    // head = newNode;
    // return;
    // }
    // newNode.next = head;
    // head = newNode;
    // }

    // public static int pop() {
    // if (isEmpty())
    // return -1;
    // int val = head.data;
    // head = head.next;
    // return val;
    // }

    // public static int peek() {
    // if (isEmpty())
    // return -1;
    // return head.data;
    // }
    // }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder res = new StringBuilder("");
        while (!s.isEmpty()) {
            res.append(s.pop());
        }
        return res.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void stockSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice >= stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int nsr[] = new int[n];
        int nsl[] = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // Stack s = new Stack();

        // stack using JCF
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s, 4);
        // while (!s.isEmpty()) {
        // System.out.println(s.pop());
        // // s.pop();
        // }
        // System.out.println(reverse("abc"));
        // reverseStack(s);
        // printStack(s);
        // int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        // int[] span = new int[stocks.length];
        // stockSpan(stocks, span);
        // for (int i = 0; i < span.length; i++) {
        // System.out.println(span[i]);
        // }
        // System.out.println(isValid("]})"));
        // System.out.println(isDuplicate("(a+b)"));
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }
}
