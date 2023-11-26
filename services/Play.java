package services;

import java.util.Scanner;

public class Play {
    static int[] players = new int[2];
    static String[] playerNames = new String[2];
    static int[][] snakes = {
            { 29, 9 },
            { 47, 4 },
            { 53, 33 },
            { 38, 15 },
            { 62, 37 },
            { 86, 54 },
            { 92, 70 },
            { 97, 25 }
    };
    static int[][] ladders = {
            { 2, 23 },
            { 8, 34 },
            { 20, 77 },
            { 32, 68 },
            { 41, 79 },
            { 74, 88 },
            { 85, 95 },
            { 82, 100 }
    };

    public static boolean isGameEnded() {
        int len = players.length;
        for (int player = 0; player < len; player++) {
            if (players[player] == 100) {
                System.out.println("Player " + (player + 1) + ": " + playerNames[player] + " is Won!!");
                return true;
            }
        }
        return false;
    }

    public static int checkPosition(int[][] positions, int position) {
        for (int i = 0; i < positions.length; i++) {
            if (positions[i][0] == position) {
                return positions[i][1];
            }
        }
        return -1;
    }

    public static int isSnake(int position) {
        return checkPosition(snakes, position);
    }

    public static int isLadder(int position) {
        return checkPosition(ladders, position);
    }

    public static void checkSnakeAndLadder(int playerPosition, int playerNumber) {
        int checkSnake = isSnake(playerPosition);
        int checkLadder = isLadder(playerPosition);
        if (checkSnake != -1) {
            players[playerNumber] = checkSnake;
            System.out.println(playerNames[playerNumber] + " got bit by snake and he/she is in the position of "
                    + players[playerNumber]);
        } else if (checkLadder != -1) {
            players[playerNumber] = checkLadder;
            System.out.println(playerNames[playerNumber] + " got ladder holy shit. Now he is in the position of "
                    + players[playerNumber]);
        } else {
            System.out.println(playerNames[playerNumber] + " in the position of " + players[playerNumber]);
        }
    }

    public static void playerTurn(int playerNumber, boolean isMachine) {
        if (!isMachine) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter 'r' to roll dice : ");
            String canRoll = input.next();
            while (!canRoll.equals("r")) {
                canRoll = input.next();
            }
            canRoll = "";
        }
        int rolledNumber = diceRoll.roll();
        if (players[playerNumber] + rolledNumber > 100) {
            System.out.println(playerNames[playerNumber] + " got out of box!!");
        } else {
            players[playerNumber] += rolledNumber;
            checkSnakeAndLadder(players[playerNumber], playerNumber);
        }
    }

    public static void startGame(int numberOfPlayer, boolean isMachine) {
        while (!isGameEnded()) {
            for (int i = 0; i < numberOfPlayer; i++) {
                playerTurn(i, isMachine);
                board.drawBoard(players);
                if (players[i] == 100) {
                    System.out.println("Game Ended");
                    break;
                }
            }
        }
    }

    public static void choice(int choice) {
        Scanner input = new Scanner(System.in);
        int numberOfPlayer = 2;
        switch (choice) {
            case 1:
                System.out.println("Enter your name");
                playerNames[0] = input.next();
                playerNames[1] = "CitiBabu";
                startGame(numberOfPlayer, true);
                break;
            case 2:
                while (true) {
                    try {
                        System.out.println("Enter No of Players : ");
                        numberOfPlayer = input.nextInt();
                        if (numberOfPlayer > 6 || numberOfPlayer < 2) {
                            System.out.println("Enter number in range 2 -6");
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Enter Integer range 2 - 6");
                        input.nextLine();
                    }
                }
                players = new int[numberOfPlayer];
                playerNames = new String[numberOfPlayer];
                input.nextLine();
                for (int i = 0; i < numberOfPlayer; i++) {
                    System.out.println("Enter player name " + (i + 1));
                    playerNames[i] = input.nextLine();
                }
                startGame(numberOfPlayer, false);
                break;
            case 3:
                break;
            default:
                break;
        }
        input.close();
    }
}