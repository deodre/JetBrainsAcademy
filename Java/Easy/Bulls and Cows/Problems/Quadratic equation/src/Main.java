import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double discriminant = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        double x1 = (-b + discriminant) / (2 * a);
        double x2 = (-b - discriminant) / (2 * a);
        System.out.println(x2 > x1 ? x1 + " " + x2 : x2 + " " + x1);
    }
}