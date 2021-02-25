package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean checkX(String input) {
        boolean firstRow = "XXX".equals(input.substring(0,3));
        boolean secondRow = "XXX".equals(input.substring(3,6));
        boolean thirdRow = "XXX".equals(input.substring(6,9));
        boolean rowVictory = firstRow ^ secondRow ^ thirdRow;

        boolean firstColumn = 'X' == input.charAt(0) && 'X' == input.charAt(3) && 'X' == input.charAt(6);
        boolean secondColumn = 'X' == input.charAt(1) && 'X' == input.charAt(4) && 'X' == input.charAt(7);
        boolean thirdColumn = 'X' == input.charAt(2) && 'X' == input.charAt(5) && 'X' == input.charAt(8);
        boolean columnVictory = firstColumn ^ secondColumn ^ thirdColumn;

        boolean mainDiagonal = 'X' == input.charAt(0) && 'X' == input.charAt(4) && 'X' == input.charAt(8);
        boolean antidiagonal = 'X' == input.charAt(2) && 'X' == input.charAt(4) && 'X' == input.charAt(6);
        boolean diagonalVictory = mainDiagonal ^ antidiagonal;

        return rowVictory ^ columnVictory ^ diagonalVictory;
    }

    public static boolean checkO(String input) {
        boolean firstRow = "OOO".equals(input.substring(0,3));
        boolean secondRow = "OOO".equals(input.substring(3,6));
        boolean thirdRow = "OOO".equals(input.substring(6,9));
        boolean rowVictory = firstRow ^ secondRow ^ thirdRow;

        boolean firstColumn = 'O' == input.charAt(0) && 'O' == input.charAt(3) && 'O' == input.charAt(6);
        boolean secondColumn = 'O' == input.charAt(1) && 'O' == input.charAt(4) && 'O' == input.charAt(7);
        boolean thirdColumn = 'O' == input.charAt(2) && 'O' == input.charAt(5) && 'O' == input.charAt(8);
        boolean columnVictory = firstColumn ^ secondColumn ^ thirdColumn;

        boolean mainDiagonal = 'O' == input.charAt(0) && 'O' == input.charAt(4) && 'O' == input.charAt(8);
        boolean antidiagonal = 'O' == input.charAt(2) && 'O' == input.charAt(4) && 'O' == input.charAt(6);
        boolean diagonalVictory = mainDiagonal ^ antidiagonal;

        return rowVictory ^ columnVictory ^ diagonalVictory;
    }

    public static int countX(String input) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if ('X' == input.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static int countO(String input) {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if ('O' == input.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean victory(String line) {
        if (checkX(line) ^ checkO(line)) {
            System.out.println(checkX(line) ? "X wins" : "O wins");
            return true;
        } else {
            int xNo = countX(line);
            int oNo = countO(line);
            if (xNo + oNo == 9 && Math.abs(xNo - oNo) == 1 && !checkX(line) && !checkO(line)) {
                System.out.println("Draw");
                return true;
            } /* else if (Math.abs(xNo - oNo) < 1) {
                System.out.println("Game not finished");
            } else {
                System.out.println("Impossible");
            } */
        }

        return false;
    }

    public static void printBoard(String line) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(line.charAt(3 * i + j) + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "         ";
        printBoard(line);
        boolean turn = true;
        System.out.println("Enter the coordinates: ");
        while (scanner.hasNext()) {
            System.out.println("Enter the coordinates: ");
            String newLine = scanner.nextLine();
            char first = newLine.charAt(0);
            char second = newLine.charAt(2);

            if (Character.isAlphabetic(first) || Character.isAlphabetic(second)) {
                System.out.println("You should enter numbers!");
                continue;
            } else {
                int valueOfFirst = Character.getNumericValue(first);
                int valueOfSecond = Character.getNumericValue(second);
                if (valueOfFirst < 1 || valueOfFirst > 3 || valueOfSecond < 1 || valueOfSecond > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                } else {
                    switch (valueOfFirst) {
                        case 1:
                            if (line.charAt(valueOfSecond - valueOfFirst) == 'X' || line.charAt(valueOfSecond - valueOfFirst) == 'O') {
                                System.out.println("This cell is occupied! Choose another one!This cell is occupied! Choose another one!");
                                continue;
                            } else {
                                char[] charLine = line.toCharArray();
                                charLine[valueOfSecond - valueOfFirst] = turn ? 'X' : 'O';
                                turn = !turn;
                                line = new String(charLine);
                            }
                            break;
                        case 2:
                            if (line.charAt(valueOfSecond + valueOfFirst) == 'X' || line.charAt(valueOfSecond + valueOfFirst) == 'O') {
                                System.out.println("This cell is occupied! Choose another one!This cell is occupied! Choose another one!");
                                continue;
                            } else {
                                char[] charLine = line.toCharArray();
                                charLine[valueOfSecond + valueOfFirst] = turn ? 'X' : 'O';
                                turn = !turn;
                                line = new String(charLine);
                            }
                            break;
                        case 3:
                            if (line.charAt(valueOfSecond + valueOfFirst + 2) == 'X' || line.charAt(valueOfSecond + valueOfFirst + 2) == 'O') {
                                System.out.println("This cell is occupied! Choose another one!This cell is occupied! Choose another one!");
                                continue;
                            } else {
                                char[] charLine = line.toCharArray();
                                charLine[valueOfSecond + valueOfFirst + 2] = turn ? 'X' : 'O';
                                turn = !turn;
                                line = new String(charLine);
                            }
                            break;
                    }
                }
            }
            printBoard(line);
            if (victory(line)) {
                break;
            }
        }
    }
}
