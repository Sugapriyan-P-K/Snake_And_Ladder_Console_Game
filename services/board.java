package services;

public class board {
    static String[][] board = {
            { "FS", "99", "98", "SN", "96", "95", "94", "93", "SN", "91" },
            { "81", "LS", "83", "84", "LS", "SN", "87", "88", "89", "90" },
            { "80", "79", "78", "77", "76", "75", "LS", "73", "72", "71" },
            { "61", "SN", "63", "64", "65", "66", "67", "68", "69", "70" },
            { "60", "59", "58", "57", "56", "55", "54", "SN", "52", "51" },
            { "LS", "42", "43", "44", "45", "46", "SN", "48", "49", "50" },
            { "40", "39", "SN", "37", "36", "35", "34", "33", "LS", "31" },
            { "21", "22", "23", "24", "25", "26", "27", "28", "SN", "30" },
            { "LS", "19", "18", "17", "16", "15", "14", "13", "12", "11" },
            { "1 ", "LS", "3 ", "4 ", "5 ", "6 ", "7 ", "LS", "9 ", "10" }
    };

    static String boxPrint(int row, int col, int[] players, int length) {
        String temp = board[row][col];
        String temp2 = temp.trim();
        if (row == 0 && col == 0) {
            return "\u001B[32mFS \u001B[0m";
        }
        for (int player = 0; player < length; player++) {
            String s = Integer.toString(players[player]);
            if (s.equals(temp2)) {
                return "\u001B[33mP" + (player + 1) + "\u001B[0m ";
            }
        }
        if (temp2.equals("LS")) {
            return "\u001B[34mLS \u001B[0m";
        } else if (temp2.equals("SN")) {
            return "\u001B[31mSN \u001B[0m";
        }
        return temp + " ";
    }

    static void drawBoard(int[] players) {
        System.out.println("---------------------------------------------------------------");
        for (int row = 0; row < 10; row++) {
            System.out.print("\t");
            for (int col = 0; col < 10; col++) {
                System.out.print(boxPrint(row, col, players, players.length));
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------");
    }
}