import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy {
    public static int maxActivity(int[] start, int[] end) {
        int maxAct = 1;
        int lastEnd = end[0];
        for (int i = 0; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxAct++;
                lastEnd = end[i];
            }
        }
        return maxAct;
    }

    public static int fractionalKnapsack(int[] val, int[] weight, int W) {
        double ratio[][] = new double[val.length][2];

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity = W;
        double finalVal = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                finalVal += (ratio[i][1] * capacity);
                break;
            }
        }
        return (int) finalVal;
    }

    public static int absoluteDiff(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }
        return minDiff;
    }

    public static int longestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chainLen = 1;
        int chainEnd = pairs[0][1];
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        return chainLen;
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };
        // System.out.println(maxActivity(start, end));
        int[] val = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };
        int W = 50;
        System.out.println(fractionalKnapsack(val, weight, W));
        int[] A = { 4, 1, 8, 7 };
        int[] B = { 2, 3, 6, 5 };
        System.out.println(absoluteDiff(A, B));
        int[][] pairs = {
                { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 }
        };
        System.out.println(longestChain(pairs));

        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder());
        int count = 0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    amount -= coins[i];
                    ans.add(coins[i]);
                }
            }
        }
        System.out.println("Count of coins/notes: " + count);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
