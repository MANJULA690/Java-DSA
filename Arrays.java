
public class Arrays {

    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static int Linear_Search(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int largest(int marks[]) {
        int max = Integer.MIN_VALUE; // - infinity
        for (int i = 0; i < marks.length; i++) {
            if (max < marks[i]) {
                max = marks[i];
            }
        }
        return max;
    }

    public static int binarySearch(int arr[], int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }

    public static void reverse(int arr[]) {
        int first = 0, last = arr.length - 1;
        while (first < last) {
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;

            first++;
            last--;

        }
    }

    public static void pairs(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + ", " + arr[j] + ")");
            }
            System.out.println();
        }
    }

    public static void printSubArrays(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // brute force
    public static void maxSubarraySum(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }

        System.out.println("Max sum is: " + maxSum);
    }

    public static void prefixSum(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefixArr[] = new int[arr.length];

        // calculate prefix array
        prefixArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixArr[i] = prefixArr[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currSum = start == 0 ? prefixArr[end] : prefixArr[end] - prefixArr[start - 1];
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max sum is: " + maxSum);
    }

    public static void kadanes(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println("max sum is :" + maxSum);
    }

    public static int trappedRainWater(int arr[]) {
        int n = arr.length;
        // left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }
        // right max boundary
        int rightMax[] = new int[n];
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - arr[i];
        }
        return trappedWater;
    }

    // best time to buy and sell stocks
    public static int buyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int sellingPrice = prices[i];
            if (buyPrice < sellingPrice) {
                int profit = sellingPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = sellingPrice;
            }
        }
        return maxProfit;
    }

    public static boolean repeated(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int majorityElement(int nums[]) {
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                index = nums[i];

            }
        }
        return index;
    }

    public static void main(String args[]) {
        int numbers[] = { -1, -2, -3, -4, -4 };
        int heights[] = { 4, 2, 0, 6, 3, 2, 5 };
        int prices[] = { 7, 6, 4, 3, 1 };
        int nums[] = { 1, 2, 3, 4, 1, 2, 2, 2 };
        System.out.println(majorityElement(nums));
    }
}
