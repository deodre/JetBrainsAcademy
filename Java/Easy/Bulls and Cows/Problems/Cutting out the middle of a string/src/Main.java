import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        int middle = sequence.length() / 2;
        if (sequence.length() % 2 == 0) {
            System.out.println(sequence.substring(0, middle - 1) + sequence.substring(middle + 1));
        } else {
            System.out.println(sequence.substring(0, middle) + sequence.substring(middle + 1));
        }
    }
}