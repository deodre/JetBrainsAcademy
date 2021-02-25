import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[4][4];
        String line;
        for (int i = 0; i < 4; i++) {
            line = scanner.nextLine();
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        boolean flag = true;
        boolean condition1;
        boolean condition2;
        boolean condition3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                condition1 = matrix[i][j] == matrix[i][j + 1];
                condition2 = matrix[i][j] == matrix[i + 1][j];
                condition3 = matrix[i][j] == matrix[i + 1][j + 1];
                if (condition1 && condition2 && condition3) {
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
}