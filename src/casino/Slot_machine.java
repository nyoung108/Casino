package casino;

import java.util.Random;
import java.util.Scanner;

public class Slot_machine {

    public int play(int coins) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean valid = true;
        while (valid) {
            int pool = 0;
            try {
                System.out.println();
                System.out.println("You have " + coins + " coins");
                System.out.println();
                System.out.println("How many coins would you like to enter?");
                pool = input.nextInt();
                while (coins - pool < 0) {
                    System.out.println("You don't have enough coins");
                    System.out.println("How many coins would you like to enter?");
                    pool = input.nextInt();
                }
            } catch (Exception e) {
                System.out.println(e);
                return coins;
            }
            coins = coins - pool;
            int a = rand.nextInt(8);
            int b = rand.nextInt(8);
            int c = rand.nextInt(8);
            System.out.println();
            System.out.println("Rolling.....");
            System.out.println("Number one:   " + a);
            System.out.println("Number two:   " + b);
            System.out.println("Number three: " + c);

            if ((a == b) && (b == c)) {
                coins = coins + (pool * 3);
                System.out.println("You matched all three!");
                System.out.println("You have " + coins + " coins");

            } else if ((a == b) || (a == c) || (b == c)) {
                coins = coins + (pool * 2);
                System.out.println("You matched two numbers!");
                System.out.println("You have " + coins + " coins");

            } else {
                System.out.println("You lost");
                System.out.println("You have " + coins + " coins");

            }
            try {
                if (coins == 0) {
                    
                    return coins;
                }
                System.out.println("If You would like to play again enter 1");
                System.out.println("If You would like to exit enter 0");
                int exit = input.nextInt();

                if (exit == 0) {
                    valid=false;
                }
            } catch (Exception e) {
                System.out.println(e);
                input.next();
            }

        }
        return coins;
    }
}
