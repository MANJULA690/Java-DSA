public class Recursion {

    static void printDec(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDec(n - 1);
    }

    static void printInc(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        printInc(n - 1);
        System.out.println(n);
    }

    public static int printFact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * printFact(n - 1);
    }

    public static int printSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + printSum(n - 1);
    }

    public static int nthFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }

    public static boolean isSOrted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSOrted(arr, i + 1);
    }

    public static int firstOcc(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOcc(arr, key, i + 1);
    }

    public static int lastOcc(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOcc(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * pow(x, n - 1);
    }

    // optimised
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int half = pow(x, n / 2);
        int power = half * half;
        if (n % 2 != 0) {
            return x * power;
        }
        return power;
    }

    // tailing problem
    public static int tailing(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        // int vertical = tailing(n - 1);
        // int horizontal = tailing(n - 2);
        return tailing(n - 1) + tailing(n - 2);
    }

    // remove duplicates from a String
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currChar), map);
        }
    }

    // friends pairing problem
    public static int pairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return pairing(n - 1) + (n - 1) * pairing(n - 2);
    }

    // binary Strings without consecutive 1's
    public static void binaryStrings(int n, int lastPlace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        binaryStrings(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            binaryStrings(n - 1, 1, str + "1");
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 3, 6, 7 };
        // System.out.println(pairing(3));
        // removeDuplicates("applee", 0, new StringBuilder(""), new boolean[26]);
        binaryStrings(3, 0, "");
    }
}
