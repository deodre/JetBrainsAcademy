import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Random random = new Random();
        int sequenceMax = 0;
        int max = k;
        int seed = 0;
        for (int i = a; i <= b; i++) {
            random.setSeed(i);
            sequenceMax = 0;
            for (int j = 0; j < n; j++) {
                sequenceMax = Math.max(sequenceMax, random.nextInt(k));
            }
            if (sequenceMax < max) {
                max = sequenceMax;
                seed = i;
            }
        }
        System.out.println(seed);
        System.out.println(max);
    }
}