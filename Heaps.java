import java.util.*;

public class Heaps {

    // ArrayList<Integer> arr = new ArrayList<>();

    // public void add(int data) {
    // arr.add(data);
    // int x = arr.size() - 1;
    // int par = (x - 1) / 2;
    // while (arr.get(x) < arr.get(par)) {
    // int temp = arr.get(x);
    // arr.set(x, arr.get(par));
    // arr.set(par, temp);
    // x = par;
    // par = (x - 1) / 2;
    // }
    // }

    // public int peek() {
    // return arr.get(0);
    // }

    // public boolean isEmpty() {
    // return arr.size() == 0;
    // }

    // public int remove() {
    // int data = arr.get(0);

    // int temp = arr.get(0);
    // arr.set(0, arr.get(arr.size() - 1));
    // arr.set(arr.size() - 1, temp);

    // arr.remove(arr.size() - 1);

    // heapify(0);

    // return data;
    // }

    // public void heapify(int i) {
    // int left = 2 * i + 1;
    // int right = 2 * i + 2;
    // int minIdx = i;

    // if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
    // minIdx = left;
    // }
    // if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
    // minIdx = right;
    // }
    // if (minIdx != i) {
    // int temp = arr.get(i);
    // arr.set(i, arr.get(minIdx));
    // arr.set(minIdx, temp);
    // heapify(minIdx);
    // }
    // }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[maxIdx] > arr[left]) {
            maxIdx = left;
        }
        if (right < size && arr[maxIdx] > arr[right]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static class Point implements Comparable<Point> {
        int x, y;
        int distSq, idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    // static class Student implements Comparable<Student> {
    // String name;
    // int rank;

    // public Student(String name, int rank) {
    // this.name = name;
    // this.rank = rank;
    // }

    // @Override
    // public int compareTo(Student s2) {
    // return this.rank - s2.rank;
    // }
    // }

    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(new Student("A", 2));
        // pq.add(new Student("B", 5));
        // pq.add(new Student("C", 4));
        // pq.add(new Student("D", 1));
        // while (!pq.isEmpty()) {
        // System.out.println(pq.peek().name + "->" + pq.peek().rank);
        // pq.remove();
        // }
        // Heaps h = new Heaps();
        // h.add(3);
        // h.add(1);
        // h.add(5);
        // h.add(4);
        // while (!h.isEmpty()) {
        // System.out.println(h.peek());
        // h.remove();
        // }
        int arr[] = { 1, 2, 4, 5, 3 };
        heapSort(arr);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }
        int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        // PriorityQueue<Point> pq = new PriorityQueue<>();
        // for (int i = 0; i < points.length; i++) {
        // int distSq = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        // pq.add(new Point(points[i][0], points[i][1], distSq, i));
        // }
        // for (int i = 0; i < k; i++) {
        // System.out.println("C" + pq.remove().idx);
        // }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ropes = { 2, 3, 3, 4, 6 };
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min + min2);
        }
        System.out.println("total min cost: " + cost);
    }
}
