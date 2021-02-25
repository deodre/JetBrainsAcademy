import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().toLowerCase();
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        StringBuilder schema = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            for (char vowel : vowels) {
                if (vowel == word.charAt(i)) {
                    flag = true;
                    break;
                }
            }
            schema.append(flag ? "V" : "C");
            flag = false;
        }
        int count = 1;
        int result = 0;
        for (int i = 0; i < schema.length() - 1; i++) {
            if (schema.toString().charAt(i) == schema.toString().charAt(i + 1)) {
                count++;
                if (count >= 3) {
                    result++;
                    count = 1;
                }
            } else {
                count = 1;
            }
        }
        System.out.println(result);
    }
}