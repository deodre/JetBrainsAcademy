import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            if (n % 2 == 0) {
                if (i % 2 == 0) {
                    result = result.multiply(BigInteger.valueOf(i));
                }
            } else {
                if (i % 2 == 1) {
                    result = result.multiply(BigInteger.valueOf(i));
                }
            }
        }
        return result;
    }
}