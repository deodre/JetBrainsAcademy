import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        StringBuilder uppercase = new StringBuilder();
        StringBuilder lowercase = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        int uppercaseLimit = 65;
        for (int i = 0; i < a; i++) {
            uppercase.append(Character.toString(uppercaseLimit++));
            if (uppercaseLimit > 90) {
                uppercaseLimit = 65;
            }
        }
        int lowercaseLimit = 97;
        for (int i = 0; i < b; i++) {
            lowercase.append(Character.toString(lowercaseLimit++));
            if (lowercaseLimit > 122) {
                lowercaseLimit = 97;
            }
        }
        int digitLimit = 1;
        for (int i = 0; i < c; i++) {
            digits.append(digitLimit++);
            if (digitLimit > 9) {
                digitLimit = 1;
            }
        }
        StringBuilder password = new StringBuilder(uppercase.toString() + lowercase.toString() + digits.toString());
        if (password.length() == 1) {
            password.append(Character.toString(password.toString().charAt(0) + 1));
        } else if (password.length() == 0) {
            password.append("AB");
        }
        while (password.length() < n) {
            password.append(password);
        }
        System.out.println(password.substring(0, n));
    }
}