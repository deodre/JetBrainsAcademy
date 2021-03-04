import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        byte[] stream = inputStream.readAllBytes();
        int i = 0;
        while (i < stream.length) {
            System.out.print(stream[i]);
            i++;
        }
    }
}