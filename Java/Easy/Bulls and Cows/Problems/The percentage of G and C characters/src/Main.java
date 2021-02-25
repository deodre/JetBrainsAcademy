import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (Character.toLowerCase(sequence.charAt(i)) == 'c' || Character.toLowerCase(sequence.charAt(i)) == 'g') {
                count++;
            }
        }
        System.out.println((double) count / sequence.length() * 100);
    }
}