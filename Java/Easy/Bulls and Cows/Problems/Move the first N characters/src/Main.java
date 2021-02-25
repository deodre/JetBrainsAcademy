import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.next();
        int positions = scanner.nextInt();
        if (positions > sequence.length()) {
            System.out.println(sequence);
        } else {
            String moved = sequence.substring(positions) + sequence.substring(0, positions);
            System.out.println(moved);
        }
    }
}