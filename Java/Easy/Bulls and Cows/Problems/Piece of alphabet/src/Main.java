import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().strip();
        char[] charLine = line.toCharArray();
        boolean flag = true;
        for (int i = 0; i < charLine.length - 1; i++) {
            if (charLine[i + 1] - charLine[i] != 1) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}