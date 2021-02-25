import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextLong();
        double n = scanner.nextDouble();
        double m = scanner.nextDouble();
        Random random = new Random(k);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < n; i++) {
                if (random.nextGaussian() > m) {
                    flag = true;
                }
            }
            random.setSeed(++k);
        }
        System.out.println(k - 1);
    }
}