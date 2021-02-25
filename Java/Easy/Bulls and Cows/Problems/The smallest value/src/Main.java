import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        BigInteger m = new BigInteger(input);
        long n = 1;
        BigInteger factorial = BigInteger.valueOf(1);
        while (factorial.compareTo(m) < 0) {
            factorial = BigInteger.ONE;
            n++;
            for (int i = 1; i <= n; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
        }
        System.out.println(n);
    }
}