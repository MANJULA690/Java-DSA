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

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 3, 6, 7 };
        System.out.println(power(2, 10));
    }
}
