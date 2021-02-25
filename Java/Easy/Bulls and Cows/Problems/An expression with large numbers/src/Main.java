import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.next();
        String second = scanner.next();
        String third = scanner.next();
        String fourth = scanner.next();
        BigInteger a = new BigInteger(first);
        BigInteger b = new BigInteger(second);
        BigInteger c = new BigInteger(third);
        BigInteger d = new BigInteger(fourth);
        System.out.println(a.negate().multiply(b).add(c).subtract(d));
    }
}