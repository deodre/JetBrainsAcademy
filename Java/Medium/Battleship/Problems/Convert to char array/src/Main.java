import java.io.CharArrayWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        StringBuilder stringBuilder = new StringBuilder();
        for (String word: words) {
            stringBuilder.append(word);
        }
        charArrayWriter.write(stringBuilder.toString());
        return charArrayWriter.toCharArray();
    }
}