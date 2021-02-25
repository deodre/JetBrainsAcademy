import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float distance = scanner.nextFloat();
        float hours = scanner.nextFloat();
        System.out.println(distance / hours);
    }
}