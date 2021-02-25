import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split("\\?")[1].split("&");
        boolean flag = false;
        String pass = "";
        for (String param : params) {
            String[] pair = param.split("=");
            if ("pass".equals(pair[0])) {
                flag = true;
                pass = pair[1];
            }
            System.out.println(pair[0] + " : " + (pair.length > 1 ? pair[1] : "not found"));
        }
        if (flag) {
            System.out.println("password : "  + pass);
        }

    }
}