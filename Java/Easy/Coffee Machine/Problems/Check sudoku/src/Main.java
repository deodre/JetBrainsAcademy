import java.util.*;

public class Main {

    public static boolean checkRowOrColumn(int[][] matrix, int n, boolean isRow) {
        int sum = n * (n + 1) / 2;
        boolean isCorrect = true;
        int rowOrColumnSum;
        for (int i = 0; i < n; i++) {
            rowOrColumnSum = 0;
            for (int j = 0; j < n; j++) {
                rowOrColumnSum += isRow ? matrix[i][j] : matrix[j][i];
            }
            if (rowOrColumnSum != sum) {
                isCorrect = false;
            }
        }
        return isCorrect;
    }

    public static boolean checkBlocks(int[][] matrix, int n) {
        int sum = n * n * (n * n + 1) / 2;
        int blockLength;
        int blockSum;
        boolean isCorrect = true;
        for (int i = 0; i < n * n; i += n) {
            blockLength = 0;
            for (int j = 0; j < n * n; j += n) {
                blockSum = 0;
                blockLength += n;
                for (int k = j; k < blockLength; k++) {
                    for (int l = j; l < blockLength; l++) {
                        blockSum += matrix[k][l];
                    }
                }
                if (blockSum != sum) {
                    isCorrect = false;
                }
            }
        }
        return isCorrect;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n * n][n * n];
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        boolean areRowsCorrect = checkRowOrColumn(matrix, n * n, true);
        boolean areColumnsCorrect = checkRowOrColumn(matrix, n * n, false);
        boolean areBlocksCorrect = checkBlocks(matrix, n);
        System.out.println(areRowsCorrect && areColumnsCorrect && areBlocksCorrect ? "YES" : "NO");
    }
}