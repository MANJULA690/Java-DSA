
// import java.util.ArrayList;
// import java.util.Collections;
import java.util.*;

public class List {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static int maxArea(int height[]) {
        int maxArea = 0;
        // brute force
        // for (int i = 0; i < height.length; i++) {
        // for (int j = i + 1; j < height.length; j++) {
        // int width = j - i;
        // int length = Math.min(height[i], height[j]);
        // maxArea = Math.max(width * length, maxArea);
        // }
        // }
        // return maxArea;

        // two pointer approach
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            int length = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * length);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // brute force
    public static boolean pairSum1(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(3);
        // list.add(6);

        // // print reverse of an arraylist
        // for (int i = list.size() - 1; i >= 0; i--) {
        // System.out.print(list.get(i) + " ");
        // }
        // System.out.println();

        // // max in an AL
        // int largest = Integer.MIN_VALUE;
        // for (int i = 0; i < list.size(); i++) {
        // largest = Math.max(largest, list.get(i));
        // }
        // // System.out.println(largest);

        // // swap 2 nums in an AL
        // swap(list, 1, 3);
        // // System.out.println(list);

        // // sorting an AL
        // // System.out.println(list);
        // Collections.sort(list);
        // Collections.sort(list, Collections.reverseOrder());
        // // System.out.println(list);

        // // multi dimensional array list
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();

        // for (int i = 1; i <= 5; i++) {
        // list1.add(1 * i);
        // list2.add(2 * i);
        // list3.add(3 * i);
        // }

        // mainList.add(list1);
        // mainList.add(list2);
        // mainList.add(list3);
        // System.out.println(mainList);

        // // nested loops
        // for (int i = 0; i < mainList.size(); i++) {
        // ArrayList<Integer> currList = mainList.get(i);
        // for (int j = 0; j < currList.size(); j++) {
        // System.out.print(currList.get(j) + " ");
        // }
        // System.out.println();
        // }
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // System.out.println(maxArea(height));
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println(pairSum1(arr, 5));
    }
}
