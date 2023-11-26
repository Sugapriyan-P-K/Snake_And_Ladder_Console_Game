package services;

public class diceRoll {
    public static int roll() {
        return (int) (Math.random() * 6 - 1) + 1;
    }
}