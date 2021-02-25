import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder();
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (i != input.length() - 1) {
                if (input.charAt(i) == input.charAt(i + 1)) {
                    count++;
                } else {
                    output.append(input.charAt(i)).append(count);
                    count = 1;
                }
            } else {
                output.append(input.charAt(i)).append(count);
            }

        }
        System.out.println(output.toString());
    }
}