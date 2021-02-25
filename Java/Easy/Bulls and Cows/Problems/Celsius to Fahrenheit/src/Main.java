import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperatureInCelsius = scanner.nextDouble();
        System.out.println(temperatureInCelsius * 1.8 + 32);
    }
}