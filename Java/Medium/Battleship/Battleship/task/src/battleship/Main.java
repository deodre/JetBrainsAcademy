package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static String[][] generateMap() {
        String[][] map = new String[11][11];
        map[0][0] = " ";
        for (int i = 1; i < 11; i++) {
            map[0][i] = String.valueOf(i);
            map[i][0] = String.valueOf((char) (64 + i));
        }
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                map[i][j] = String.valueOf('~');
            }
        }
        return map;
    }

    private static void showMap(String[][] map) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static Map<String, Integer> initializeBattleships() {
        Map<String, Integer> battleships = new LinkedHashMap<>();
        battleships.put("Aircraft Carrier", 5);
        battleships.put("Battleship", 4);
        battleships.put("Submarine", 3);
        battleships.put("Cruiser", 3);
        battleships.put("Destroyer", 2);
        return battleships;
    }

    private static boolean checkCoordinates(String c1, String c2, int battleshipSize, String battleship) {
        if (c1.charAt(0) == c2.charAt(0)) {
            try {
                int inputBattleshipSize = Math.abs(Integer.parseInt(c2.substring(1))
                        - Integer.parseInt(c1.substring(1)));
                if (inputBattleshipSize == battleshipSize - 1) {
                    return true;
                } else {
                    System.out.printf("Error! Wrong length of the %s! Try again:\n", battleship);
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Error! Invalid input!\n");
                return false;
            }
        } else if (c1.charAt(1) == c2.charAt(1)) {
            try {
                int inputBattleshipSize = Math.abs(c2.charAt(0) - c1.charAt(0));
                if (inputBattleshipSize == battleshipSize - 1) {
                    return true;
                } else {
                    System.out.printf("Error! Wrong length of the %s! Try again:\n", battleship);
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Error! Invalid input!");
                return false;
            }
        } else {
            System.out.println("Error! Wrong ship location! Try again:\n");
            return false;
        }
    }

    private static boolean checkNeighbours(String[][] map, int x, int y) {
        try {
            return map[x][y].equals("O");
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean checkSurroundings(String c1, String c2, String[][] map) {
        try {
            int x1 = c1.charAt(0) - 64;
            int x2 = c2.charAt(0) - 64;
            int y1 = Integer.parseInt(c1.substring(1));
            int y2 = Integer.parseInt(c2.substring(1));
            if (x1 == x2) {
                if (y2 < y1) {
                    y1 += y2;
                    y2 = y1 - y2;
                    y1 -= y2;
                }
                for (int i = 0; i <= y2 - y1; i++) {
                    if (checkNeighbours(map, x1 - 1, y1 + i - 1)
                            || checkNeighbours(map, x1 - 1, y1 + i)
                            || checkNeighbours(map, x1 - 1, y1 + i + 1)
                            || checkNeighbours(map, x1, y1 + i - 1)
                            || checkNeighbours(map, x1, y1 + i)
                            || checkNeighbours(map, x1, y1 + i + 1)
                            || checkNeighbours(map, x1 + 1, y1 + i - 1)
                            || checkNeighbours(map, x1 + 1, y1 + i)
                            || checkNeighbours(map, x1 + 1, y1 + i + 1)) {
                        System.out.println("Error! You placed it too close to another one. Try again:\n");
                        return false;
                    }
                }
                return true;
            } else if (y1 == y2) {
                if (x2 < x1) {
                    x1 += x2;
                    x2 = x1 - x2;
                    x1 -= x2;
                }
                for (int i = 0; i <= x2 - x1; i++) {
                    if (checkNeighbours(map, x1 + i - 1, y1 - 1)
                            || checkNeighbours(map, x1 + i, y1 - 1)
                            || checkNeighbours(map, x1 + i + 1, y1 - 1)
                            || checkNeighbours(map, x1 + i - 1, y1)
                            || checkNeighbours(map, x1 + i, y1)
                            || checkNeighbours(map, x1 + i + 1, y1)
                            || checkNeighbours(map, x1 + i - 1, y1 + 1)
                            || checkNeighbours(map, x1 + i, y1 + 1)
                            || checkNeighbours(map, x1 + i + 1, y1 + 1)) {
                        System.out.println("Error! You placed it too close to another one. Try again:\n");
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error! Wrong ship location! Try again:\n");
            return false;
        }
        return false;
    }

    public static void setBattleship(String c1, String c2, String[][] map, Map<int[], Integer> locations, int battleshipSize) {
        int x1 = c1.charAt(0) - 64;
        int x2 = c2.charAt(0) - 64;
        int y1 = Integer.parseInt(c1.substring(1));
        int y2 = Integer.parseInt(c2.substring(1));
        if (x1 == x2) {
            if (y2 < y1) {
                y1 += y2;
                y2 = y1 - y2;
                y1 -= y2;
            }
            locations.put(new int[] {x1, y1, 0}, battleshipSize);
            for (int i = 0; i <= y2 - y1; i++) {
                map[x1][y1 + i] = "O";
            }
        } else if (y1 == y2) {
            if (x2 < x1) {
                x1 += x2;
                x2 = x1 - x2;
                x1 -= x2;
            }
            locations.put(new int[] {x1, y1, 1}, battleshipSize);
            for (int i = 0; i <= x2 - x1; i++) {
                map[x1 + i][y1] = "O";
            }
        }

    }

    public static int checkRemainingShips(Map<int[], Integer> battleshipLocations, String[][] map, String message) {
        boolean oneShipHasSunk = false;
        int[] battleshipLocation = null;
        for (Map.Entry<int[], Integer> location : battleshipLocations.entrySet()) {
            oneShipHasSunk = true;
            if (location.getKey()[2] == 0) {
                for (int i = 0; i < location.getValue(); i++) {
                    if (!map[location.getKey()[0]][location.getKey()[1] + i].equals("X")) {
                        oneShipHasSunk = false;
                        break;
                    }
                }
            } else if (location.getKey()[2] == 1) {
                for (int i = 0; i < location.getValue(); i++) {
                    if (!map[location.getKey()[0] + i][location.getKey()[1]].equals("X")) {
                        oneShipHasSunk = false;
                        break;
                    }
                }
            }

            if (oneShipHasSunk) {
                battleshipLocation = location.getKey();
                break;
            }
        }

        if (oneShipHasSunk) {
            battleshipLocations.remove(battleshipLocation);
        }

        if (battleshipLocations.size() == 0) {
            System.out.println("You sank the last ship. You won. Congratulations!");
        } else if (oneShipHasSunk) {
            System.out.println("You sank a ship!");
        } else {
            System.out.println(message);
        }
        return battleshipLocations.size();
    }

    public static void main(String[] args) {
        String[][] map1 = generateMap();
        String[][] map2 = generateMap();
        String[][] fogMap1 = generateMap();
        String[][] fogMap2 = generateMap();

        String[][][] maps = { map1, map2};
        String[][][] fogMaps = { fogMap1, fogMap2};

        Map<String, Integer> battleships = initializeBattleships();
        Map<int[], Integer> battleshipLocations1 = new HashMap<>();
        Map<int[], Integer> battleshipLocations2 = new HashMap<>();
        List<Map<int[], Integer>> battleshipLocations = new ArrayList<>();
        battleshipLocations.add(battleshipLocations1);
        battleshipLocations.add(battleshipLocations2);

        String line;
        String c1;
        String c2;
        boolean validCoordinates;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 2; i++) {
                System.out.println("Player " + (i + 1) + ", place your ships on the game field");
                for (Map.Entry<String, Integer> battleship : battleships.entrySet()) {
                    showMap(maps[i]);
                    validCoordinates = false;
                    System.out.printf("Enter the coordinates of the %s (%d cells):\n", battleship.getKey(), battleship.getValue());
                    while (!validCoordinates) {
                        line = reader.readLine();
                        c1 = line.split(" ")[0];
                        c2 = line.split(" ")[1];
                        validCoordinates = checkCoordinates(c1, c2, battleship.getValue(), battleship.getKey()) && checkSurroundings(c1, c2, maps[i]);
                        if (validCoordinates) {
                            setBattleship(c1, c2, maps[i], battleshipLocations.get(i), battleship.getValue());
                        }
                    }
                }
                showMap(maps[i]);
                System.out.println("Press Enter and pass the the move to another player\n...");
                reader.readLine();
                System.out.flush();
            }

            int remainingShips1 = battleshipLocations1.size();
            int remainingShips2 = battleshipLocations2.size();
            while(remainingShips1 != 0 && remainingShips2 != 0) {
                showMap(fogMap1);
                System.out.println("---------------------");
                showMap(map1);
                System.out.println("Player 1, it's your turn:");
                line = reader.readLine();
                int x = line.charAt(0) - 64;
                int y = Integer.parseInt(line.substring(1));
                if (x < 11 && y < 11) {
                    if (map2[x][y].equals("O") || map2[x][y].equals("X")) {
                        map2[x][y] = "X";
                        fogMap1[x][y] = "X";
                        remainingShips2 = checkRemainingShips(battleshipLocations2, fogMap1, "You hit a ship!");
                    } else if (map2[x][y].equals("~")) {
                        map2[x][y] = "M";
                        fogMap1[x][y] = "M";
                        System.out.println("You missed!");
                    }
                }

                System.out.println("Press Enter and pass the the move to another player\n...");
                reader.readLine();
                System.out.flush();

                showMap(fogMap2);
                System.out.println("---------------------");
                showMap(map2);
                System.out.println("Player 2, it's your turn:");

                line = reader.readLine();
                x = line.charAt(0) - 64;
                y = Integer.parseInt(line.substring(1));
                if (x < 11 && y < 11) {
                    if (map1[x][y].equals("O") || map1[x][y].equals("X")) {
                        map1[x][y] = "X";
                        fogMap2[x][y] = "X";
                        remainingShips1 = checkRemainingShips(battleshipLocations1, fogMap2, "You hit a ship!");
                    } else if (map2[x][y].equals("~")) {
                        map1[x][y] = "M";
                        fogMap2[x][y] = "M";
                        System.out.println("You missed!");
                    }
                }

                System.out.println("Press Enter and pass the the move to another player\n...");
                reader.readLine();
                System.out.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
