import java.util.*;

class FixingStringIndexOutOfBoundsException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        int index = scanner.nextInt();

        System.out.println(index >= string.length() || index < 0 ? "Out of bounds!" : string.charAt(index));
    }
}