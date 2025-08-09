import java.util.*;

public class Hashing {

    public static boolean validAnagram(String s, String t) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), t.contains(s));
        }
        for (Character key : map.keySet()) {
            if (map.get(key) == false) {
                return false;
            }
        }
        return true;
    }

    public static int distinct(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size();
    }

    public static void unionIntersection(int[] arr1, int[] arr2) {
        // union
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            set.add(num);
        }
        System.out.println("union: " + set.size());

        // intersection
        int count = 0;
        set.clear();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            if (set.contains(num)) {
                count++;
                System.out.print(num + " ");
                set.remove(num);
            }
        }
        System.out.println("intersection : " + count);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        // map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }

        // for (Integer key : map.keySet()) {
        // if (map.get(key) > nums.length / 3) {
        // System.out.println(key);
        // }
        // }
        // System.out.println(validAnagram("race", "care"));

        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Grapes");
        set.add("Watermelon");
        // Iterator it = set.iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }

        // for (String s : set) {
        // System.out.println(s);
        // }

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Apple");
        lhs.add("Banana");
        lhs.add("Mango");
        lhs.add("Grapes");
        lhs.add("Watermelon");
        // System.out.println(lhs);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Apple");
        ts.add("Banana");
        ts.add("Mango");
        ts.add("Grapes");
        ts.add("Watermelon");
        // System.out.println(ts);
        // System.out.println(distinct(nums));
        int[] arr1 = { 7, 3, 9, 4 };
        int[] arr2 = { 6, 3, 9, 2, 9, 4 };
        unionIntersection(arr1, arr2);
    }
}
