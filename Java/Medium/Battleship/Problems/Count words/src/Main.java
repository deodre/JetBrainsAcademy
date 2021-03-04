import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String words = reader.readLine().trim();
        System.out.println(words.isEmpty() ? 0 : words.split("\\s+").length);
        reader.close();
    }
}