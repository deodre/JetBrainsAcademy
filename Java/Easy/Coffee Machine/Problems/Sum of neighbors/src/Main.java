import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> readLines = new ArrayList<>();
        String currentLine = scanner.nextLine();
        do {
            readLines.add(currentLine);
            currentLine = scanner.nextLine();
        } while (!"end".equals(currentLine));
        


        int sizeOfMatrix = readLines.get(0).split(" ").length;
        int[][] matrix = new int[readLines.size()][sizeOfMatrix];
        for (int i = 0; i < readLines.size(); i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                matrix[i][j] = Integer.parseInt(readLines.get(i).split(" ")[j]);
            }
        }
        int sum = 0;
        for (int i = 0; i < readLines.size(); i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                sum = matrix[i - 1 < 0 ? readLines.size() - 1 : i - 1][j] +
                        matrix[i + 1 > readLines.size() - 1 ? 0 : i + 1][j] +
                        matrix[i][j - 1 < 0 ? sizeOfMatrix - 1 : j - 1] +
                        matrix[i][j + 1 > sizeOfMatrix - 1 ? 0 : j + 1];
                System.out.print(sum + " ");
            }
            System.out.print("\n");
        }
    }
}