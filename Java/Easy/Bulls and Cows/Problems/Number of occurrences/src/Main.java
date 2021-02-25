import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        String pattern = scanner.nextLine();
        int count = 0;
        while (sequence.contains(pattern)) {
            count++;
            sequence = sequence.substring(sequence.indexOf(pattern) + pattern.length());
        }
        System.out.println(count);
    }
}