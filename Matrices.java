import java.util.*;

public class Matrices {

    public static boolean search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("key found at cell : (" + i + " ," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static int largest(int matrix[][]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                largest = Math.max(largest, matrix[i][j]);
            }
        }
        return largest;
    }

    public static int smallest(int matrix[][]) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                smallest = Math.min(smallest, matrix[i][j]);
            }
        }
        return smallest;
    }

    // spiral matrix
    public static void printSprial(int matrix[][]) {
        int startRow = 0, startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                System.out.print(matrix[endRow][j] + " ");
                if (startRow == endRow) {
                    break;
                }
            }

            // left
            for (int i = endRow - 1; i > startRow; i--) {
                System.out.print(matrix[i][startCol] + " ");
                if (startCol == endCol) {
                    break;
                }
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }

    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        return sum;
    }

    public static boolean stairCase(int matrix[][], int key) {
        // int row = 0;
        // int col = matrix[0].length - 1;
        // while (row < matrix.length && col >= 0) {
        // if (matrix[row][col] == key) {
        // System.out.println("key found at : (" + row + " ," + col + ")");
        // return true;
        // } else if (key < matrix[row][col]) {
        // col--;
        // } else {
        // row++;
        // }
        // }
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == key) {
                System.out.println("key found at : (" + row + " ," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                row--;
            } else {
                col++;
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static void main(String args[]) {

        // // input
        // Scanner sc = new Scanner(System.in);
        // int maxtrix[][] = new int[3][3];
        // // int n = 3, m = 3;
        // int n = maxtrix.length, m = maxtrix[0].length;
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // maxtrix[i][j] = sc.nextInt();
        // }
        // }

        // // output
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print(maxtrix[i][j] + " ");
        // }
        // System.out.println();
        // }

        // search(maxtrix, 5);
        // System.out.println(largest(maxtrix));
        // System.out.println(smallest(maxtrix));

        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        // printSprial(matrix);
        // System.out.println(diagonalSum(matrix));
        stairCase(matrix, 14);
    }
}
