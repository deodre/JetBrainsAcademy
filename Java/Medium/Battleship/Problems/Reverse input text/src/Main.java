import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Character> chars = new ArrayList<>();
        int charAsNumber = reader.read();
        while (charAsNumber != -1) {
            chars.add(0, (char) charAsNumber);
            charAsNumber = reader.read();
        }
        for (Character reversed : chars) {
            System.out.print(reversed);
        }
        reader.close();
    }
}