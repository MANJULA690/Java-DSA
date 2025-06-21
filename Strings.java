import java.util.*;

public class Strings {

    public static void printName(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
        }
    }

    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static float shortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            if (dir == 'N')
                y++;
            else if (dir == 'S')
                y--;
            else if (dir == 'W')
                x--;
            else
                x++;
        }
        return (float) Math.sqrt(x * x + y * y);
    }

    // lexographically largest String
    public static String largestStr(String arr[]) {
        String largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (largest.compareTo(arr[i]) < 0) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static String compress(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        // System.out.println(isPalindrome("racecar"));
        // System.out.println(shortestPath("NS"));
        // String fruits[] = { "apple", "mango", "banana" };
        // System.out.println(largestStr(fruits));
        String str = "abcd";
        System.out.println(compress(str));
    }
}
