import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if ("0".equals(input)) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                System.out.println(10 * number);
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Invalid user input: " + input);
            }
        }
    }
}