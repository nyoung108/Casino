package casino;

import java.util.Random;
import java.util.Scanner;

public class Roulette {

    public int play(int coins) {
        Scanner input = new Scanner(System.in);

        boolean valid = true;
        while (valid) {
            try {
                System.out.println();
                System.out.println("You have " + coins + " coins");
                System.out.println();
                System.out.println("If you would like to bet on odd or even enter 1");
                System.out.println("If you would like to bet on red or black enter 2");
                System.out.println("If you would like to bet on a single number enter 3");
                System.out.println("If you would like to bet on green enter 4");
                System.out.println("If you would like to exit enter 0");
                int selected = input.nextInt();
                switch (selected) {
                    case 0:
                        valid = false;
                        break;
                    case 1:
                        OddorEven(coins);
                        break;
                    case 2:
                        BlackOrRed(coins);
                        break;
                    case 3:
                        Number(coins);
                        break;
                    case 4:
                        Green(coins);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
                input.next();
            }
        }
        return coins;
    }

    public int OddorEven(int coins) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        try {
            System.out.println();
            System.out.println("If you would like to bet on odd enter 1");
            System.out.println("If you would like to bet on even enter 2");
            int bet = input.nextInt();

            System.out.println("How many coins would you like to enter?");
            int pool = input.nextInt();
            while(coins-pool<0){
                System.out.println("You don't have enough coins");
                System.out.println("How many coins would you like to enter?");
                pool = input.nextInt();
            }

            int roll = rand.nextInt(37);

            int landed = (roll % 2);

            System.out.println();
            System.out.println("Rolling.....");

            if (roll != 0) {
                if ((landed == 0) && (bet == 2)) {
                    System.out.println("You win! The number rolled was " + roll);
                    coins = coins + pool;
                }
                if ((landed == 1) && (bet == 1)) {
                    System.out.println("You win! The number rolled was " + roll);
                    coins = coins + pool;

                } else {
                    System.out.println("You lost! The number rolled was " + roll);
                    coins = coins - pool;
                }
            } else {
                System.out.println("You lost! The number rolled was " + roll);
                coins = coins - pool;
            }
        } catch (Exception e) {
            System.out.println(e);
            input.next();
        }

        return coins;
    }

    public int BlackOrRed(int coins) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        try {
            System.out.println();
            System.out.println("If you would like to bet on black enter 1");
            System.out.println("If you would like to bet on red enter 2");
            int bet = input.nextInt();

            System.out.println();
            System.out.println("How many coins would you like to enter?");
            int pool = input.nextInt();
            while(coins-pool<0){
                System.out.println("You don't have enough coins");
                System.out.println("How many coins would you like to enter?");
                pool = input.nextInt();
            }
            int[] Black = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
            int[] Red = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 35, 27, 30, 32, 34, 36};
            int roll = rand.nextInt(37);
            int colour = -1;
            String rolledColour = "colour";
            for (int i = 0; i < Black.length; i++) {
                if (roll == Black[i]) {
                    colour = 1;
                    rolledColour = "Black";
                }
                if (roll == Red[i]) {
                    colour = 2;
                    rolledColour = "Red";
                }
            }
            if (roll == 0) {
                rolledColour = "Green";
            }
            if (bet == colour) {
                System.out.println("You win! The colour rolled was " + rolledColour);
                coins = coins + pool;
            } else {
                System.out.println("You lost! The colour was " + rolledColour);
                coins = coins - pool;
            }
        } catch (Exception e) {
            System.out.println(e);
            input.next();
        }

        return coins;

    }

    public int Number(int coins) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        try {
            System.out.println("What number do you want to bet on");
            int bet = input.nextInt();

            System.out.println();
            System.out.println("How many coins would you like to enter?");
            int pool = input.nextInt();
            while(coins-pool<0){
                System.out.println("You don't have enough coins");
                System.out.println("How many coins would you like to enter?");
                pool = input.nextInt();
            }
            int roll = rand.nextInt(37);
            if (roll == bet) {
                System.out.println("You win! The number rolled was " + roll);
                coins = coins + (pool * 10);
            } else {
                System.out.println("You lost! The number rolled was " + roll);
                coins = coins - pool;
            }
        } catch (Exception e) {
            System.out.println(e);
            input.next();
        }
        return coins;
    }

    public int Green(int coins) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        try {
            System.out.println();
            System.out.println("How many coins would you like to enter?");
            int pool = input.nextInt();
            while(coins-pool<0){
                System.out.println("You don't have enough coins");
                System.out.println("How many coins would you like to enter?");
                pool = input.nextInt();
            }
            int roll = rand.nextInt(37);
            if (roll == 0) {
                System.out.println("You win! The colour rolled was green");
                coins = coins + (pool * 10);
            } else {
                System.out.println("You lost! The coulor rolled was not green");
                coins = coins - pool;
            }
        } catch (Exception e) {
            System.out.println(e);
            input.next();
        }

        return coins;
    }
}
