import java.util.*;
import java.util.LinkedList;

public class QueueB {

    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek is : " + s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    static class Queues {
        static int[] arr;
        static int rear;
        static int front;
        static int size;

        Queues(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int result = arr[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return arr[front];
        }

    }

    public static void nonRepeating(String str) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void reverse(Queue<Integer> q) {
        // Stack<Integer> s = new Stack<>();
        // while (!q.isEmpty()) {
        // s.push(q.remove());
        // }
        // while (!s.isEmpty()) {
        // q.add(s.pop());
        // }
    }

    // Queue q = new Queue(
    // 3);q.add(1);q.add(2);q.add(3);System.out.println(q.remove());q.add(4);System.out.println(q.remove());q.add(5);while(!q.isEmpty())
    // {
    // System.out.println(q.peek());
    // q.remove();
    // }

    // nonRepeating("aabccxb");

}
