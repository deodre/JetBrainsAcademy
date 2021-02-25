import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] sequence = scanner.nextLine().toCharArray();
        for (char letter : sequence) {
            System.out.print(letter + "" + letter);
        }

    }
}