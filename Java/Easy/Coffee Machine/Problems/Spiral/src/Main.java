import java.util.Scanner;

enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT
}
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int number = 1;
        Direction direction = Direction.RIGHT;
        int i = 0;
        int j = 0;

        while (number <= n * n) {
            switch (direction) {
                case RIGHT:
                    for (; j < n - i; j++) {
                        matrix[i][j] = number;
                        number++;
                    }
                    j--;
                    i++;
                    direction = Direction.DOWN;
                    break;
                case DOWN:
                    for (; i < j + 1; i++) {
                        matrix[i][j] = number;
                        number++;
                    }
                    i--;
                    j--;
                    direction = Direction.LEFT;
                    break;
                case LEFT:
                    for (; j >= n - i; j--) {
                        matrix[i][j] = number;
                        number++;
                    }
                    direction = Direction.UP;
                    break;
                case UP:
                    for (; i > j; i--) {
                        matrix[i][j] = number;
                        number++;
                    }
                    i++;
                    j++;
                    direction = Direction.RIGHT;
                    break;
                default:
                    break;
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}