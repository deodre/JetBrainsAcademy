import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        Optional<String> maxLengthString = Arrays.stream(line).max(Comparator.comparing(String::length));
        System.out.println(maxLengthString.orElse(""));
    }
}