import java.util.ArrayList;

public class ArrayLIST {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        // print reverse of an arraylist
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // max in an AL
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            largest = Math.max(largest, list.get(i));
        }
        System.out.println(largest);

        // swap 2 nums in an AL
        swap(list, 1, 3);
        System.out.println(list);
    }
}
