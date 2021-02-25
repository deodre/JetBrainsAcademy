import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        StringBuilder emptySeats = new StringBuilder();
        StringBuilder row = new StringBuilder();
        int rowNo = 0;
        emptySeats.append("0".repeat(Math.max(0, k)));
        for (int i = 0; i < n; i++) {
            row.setLength(0);
            for (int j = 0; j < m; j++) {
                row.append(matrix[i][j]);
            }
            if (row.toString().contains(emptySeats.toString())) {
                rowNo = i + 1;
                break;
            }
        }

        System.out.println(rowNo);
    }
}