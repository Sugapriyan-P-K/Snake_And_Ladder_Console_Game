import java.util.Scanner;

import services.Play;

public class driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Press 1. Player Vs Machine");
        System.out.println("Press 2. Number of Players Limits (2 - 6)");
        System.out.println("Press any number to exit");
        int playChoice = 1; // defaultly set to 1
        try {
            playChoice = input.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
        Play.choice(playChoice);
        input.close();
    }
}