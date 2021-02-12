package casino;

import java.util.Scanner;
import java.util.Random;


public class Casino {

    

    public static void main(String[] args) {

        int coins = 100;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my Casino");

        boolean valid = true;
        Slot_machine slot_machine = new Slot_machine();
        Roulette roulette = new Roulette();
        BlackJack blackJack = new BlackJack();
        while (valid) {
            try {
                System.out.println("You have " + coins + " coins");
                System.out.println("If you would like to play the Slot machine enter 1");
                System.out.println("If you would like to play the Roulette enter 2");
                System.out.println("If you would like to play Black Jack enter 3");
                System.out.println("If you would like enter the prize exchange enter 4");
                System.out.println("If you would like to exit enter 0");
                int selected = input.nextInt();

                switch (selected) {
                    case 1:
                        coins = slot_machine.play(coins);
                        break;
                    case 2:
                        coins = roulette.play(coins);
                        break;
                    case 3:
                        coins = blackJack.play(coins);
                        break;
                    case 4:
                        coins = prizeExchange(coins);
                        break;
                    default:
                        valid = false;
                }
            } catch (Exception e) {
                System.out.println(e);
                input.next();
            }
        }
    }

    public static int prizeExchange(int coins) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        try {
            System.out.println("You have "+coins+" coins");
            System.out.println("If you would like a Star Wars scene for 100 coins, enter 1");
            System.out.println("If you would like to exit, enter 0");
            
            int selected = input.nextInt();
            switch (selected) {
                case 1:
                    while (coins >= 100) {
                        String[] quotes = new String[8];
                        quotes[0] = "Hello there - General Kenobi";
                        quotes[1] = "I am the senate - Emperor Palpatine";
                        quotes[2] = "Sad beep - R2D2";
                        quotes[3] = "Another happy landing - Obi Wan Kenobi";
                        quotes[4] = "A fine addition to my collection - General Grievous";
                        quotes[5] = "It's treason then - Emperor Palpatine";
                        quotes[6] = "Unlimited powwweeeeeeerrrrrr - Emperor Palpatine";
                        quotes[7] = "*Sarcastic* Good job - Obi Wan Kenobi";
                        int random = rand.nextInt(8);
                        System.out.println(quotes[random]);
                        coins = coins - 100;
                    }
                    break;
                default:

                    break;
            }

        } catch (Exception e) {
            System.out.println(e);
            input.next();
        }
        return coins;
    }

}
