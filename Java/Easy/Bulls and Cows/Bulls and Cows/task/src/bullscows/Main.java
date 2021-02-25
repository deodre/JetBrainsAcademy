package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static boolean cowCheck(char[] secret, char digit) {
        for (char secretDigit : secret) {
            if (digit == secretDigit) {
                return true;
            }
        }
        return false;
    }

    public static String generateSecret(int length, int range){
        String possibleValues = generatePossibleValues(range);
        StringBuilder secret = new StringBuilder();
        Random random = new Random();
        while (length > secret.length()) {
            int position = random.nextInt(range);
            if (!secret.toString().contains(String.valueOf(possibleValues.charAt(position)))) {
                secret.append(possibleValues.charAt(position));
            }
        }
        return secret.toString();
    }

    public static String generatePossibleValues(int range) {
        StringBuilder possibleValues = new StringBuilder("0123456789");
        for (int i = 0; i < range - 10; i++) {
            possibleValues.append((char) (i + 97));
        }
        return possibleValues.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String length = scanner.nextLine();
        try {
            int secretLength = Integer.parseInt(length);
            System.out.println("Input the number of possible symbols in the code:");
            String range = scanner.nextLine();
            try {
                int secretRange = Integer.parseInt(range);
                if (secretRange < secretLength) {
                    System.out.println("Error: it's not possible to generate a code with a length of " + secretLength + " with " + secretRange + " unique symbols.");
                } else  if (secretRange > 36 || secretLength < 1) {
                    System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                } else {
                    String secret = generateSecret(secretLength, secretRange);
                    String possibleValues = generatePossibleValues(secretRange);
                    String numberRange;
                    String letterRange;
                    if (secretRange < 11) {
                        numberRange = "(" + possibleValues.charAt(0) + "-" + possibleValues.charAt(secretRange - 1) + ")";
                        letterRange = "";
                    } else if (secretRange == 11) {
                        numberRange = "(0-9, ";
                        letterRange = "a)";
                    } else {
                        numberRange = "(0-9, a-";
                        letterRange = possibleValues.charAt(possibleValues.length() - 1) + ")";
                    }
                    String rangeText = "The secret is prepared: " + "*".repeat(Math.max(0, secretLength)) + " " + numberRange + letterRange;
                    System.out.println(rangeText);
                    String guess;
                    int cows;
                    int bulls = 0;
                    int turns = 0;
                    while (bulls != secretLength) {
                        bulls = 0;
                        cows = 0;
                        turns++;
                        System.out.println("Turn " + turns);
                        guess = scanner.next();
                        for (int i = 0; i < guess.length(); i++) {
                            if (cowCheck(secret.toCharArray(), guess.charAt(i))) {
                                if (guess.charAt(i) == secret.charAt(i)) {
                                    bulls++;
                                } else {
                                    cows++;
                                }
                            }
                        }
                        if (cows > 0 && bulls > 0) {
                            System.out.printf("Grade: %d bull(s) and %d cows(s)\n", bulls, cows);
                        } else if (cows > 0 && bulls == 0) {
                            System.out.printf("Grade %d cow(s)\n", cows);
                        } else if (cows == 0 && bulls > 0) {
                            System.out.printf("Grade %d bull(s)\n", bulls);
                        } else {
                            System.out.println("Grade: None\n");
                        }
                    }
                    System.out.println("Congratulations! You guessed the secret code.");
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Error: " + range + " isn't a valid number.");
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Error: " + length + " isn't a valid number.");
        }
    }
}
