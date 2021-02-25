import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int sumOfFirst = 0;
        int sumOfLast = 0;
        for (int i = 0; i < 3; i++) {
            sumOfFirst += Character.getNumericValue(number.charAt(i));
            sumOfLast += Character.getNumericValue(number.charAt(number.length() - 1 - i));
        }
        System.out.println(sumOfFirst == sumOfLast ? "Lucky" : "Regular");
    }
}