import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = i - j;
                System.out.print(matrix[i][j] + " ");
            }
            for (int k = 1; k < n - i; k++) {
                matrix[i][k] = k;
                System.out.print(matrix[i][k] + " ");
            }
            System.out.print("\n");
        }
    }
}