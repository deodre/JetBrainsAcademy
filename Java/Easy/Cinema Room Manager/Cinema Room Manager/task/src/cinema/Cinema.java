package cinema;

import java.util.Scanner;

public class Cinema {

    public static String[][] generateCinema(int rows, int seatsPerRow) {
        String[][] cinema = new String[rows + 1][seatsPerRow + 1];
        cinema[0][0] = " ";
        for (int i = 1; i <= seatsPerRow; i++) {
            cinema[0][i] = String.valueOf(i);
        }
        for (int i = 1; i <= rows; i++) {
            cinema[i][0] = String.valueOf(i);
            for (int j = 1; j <= seatsPerRow; j++) {
                cinema[i][j] = "S";
            }
        }
        return cinema;
    }

    public static void displayState(String[][] cinema, int rows, int seatsPerRow) {
        System.out.println("\nCinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seatsPerRow; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void displayMenu() {
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit\n");
    }

    public static int calculateTotalIncome(int rows, int seatsPerRow) {
        if (rows * seatsPerRow <= 60) {
            return rows * seatsPerRow * 10;
        } else {
            if (rows % 2 == 0) {
                return rows / 2 * seatsPerRow * 18;
            } else {
                return rows * seatsPerRow * 9 - seatsPerRow;
            }
        }
    }

    public static int buyTicket(int rows, int seatsPerRow, int row, int seat, String[][] cinema) {
        if (row > rows || row < 1 || seat > seatsPerRow || seat < 1) {
            System.out.println("Wrong input!");
            return 0;
        } else if ("B".equals(cinema[row][seat])) {
            System.out.println("That ticket has already been purchased!");
            return 0;
        } else {
            cinema[row][seat] = "B";
            if (rows * seatsPerRow <= 60) {
                System.out.println("Ticket price: $10");
                return 10;
            } else {
                if (row <= rows / 2) {
                    System.out.println("Ticket price: $10");
                    return 10;
                } else {
                    System.out.println("Ticket price: $8");
                    return 8;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();
        String[][] cinema = generateCinema(rows, seatsPerRow);
        displayMenu();
        int numberOfPurchasedTickets = 0;
        int currentIncome = 0;
        int totalIncome = calculateTotalIncome(rows, seatsPerRow);
        while (scanner.hasNext()) {
            int option = scanner.nextInt();
            if (option == 0) {
                break;
            } else if (option == 1) {
                displayState(cinema, rows, seatsPerRow);
                displayMenu();
            } else if (option == 2) {
                int ticketPrice = 0;
                while (ticketPrice == 0) {
                    System.out.println("Enter a row number:");
                    int row = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int seat = scanner.nextInt();
                    ticketPrice = buyTicket(rows, seatsPerRow, row, seat, cinema);
                }
                numberOfPurchasedTickets++;
                currentIncome += ticketPrice;
                displayMenu();
            } else if (option == 3) {
                float percentage = (float) numberOfPurchasedTickets * 100 / (rows * seatsPerRow);
                char percentageSign = '%';
                System.out.printf("Number of purchased tickets: %d\nPercentage: %.2f%c\nCurrent income: $%d\nTotal income: $%d", numberOfPurchasedTickets, percentage, percentageSign, currentIncome, totalIncome);
            }
        }
    }
}