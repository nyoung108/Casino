package casino;

import java.util.Scanner;
import java.util.Random;

public class Casino {

    public static void main(String[] args) {
//I had a go at file handling but I struggled and left it too late so I will try and add it over half term
        int coins = 1000;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my Casino");

        boolean valid = true;

        while (valid) {
            try {
                Slot_machine slot_machine = new Slot_machine();
                Roulette roulette = new Roulette();
                BlackJack blackJack = new BlackJack();
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
                if (coins == 0) {
                    System.out.println("The house always wins. You are out of coins");
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
            System.out.println("You have " + coins + " coins");
            System.out.println("If you would like a Star Wars quote for 100 coins, enter 1");
            System.out.println("If you would like an ASCII bear for 200 coins, enter 2");
            System.out.println("If you would like to exit, enter 0");

            int selected = input.nextInt();
            switch (selected) {
                case 1:
                    if (coins >= 100) {
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
                    if (coins < 100) {
                        System.out.println("Sorry you dont have enough coins");
                    }
                    break;
                case 2:
                    while (coins >= 200) {
                        System.out.println(":\"'._..---.._.'\";\n"
                                + "    `.             .'\n"
                                + "    .'    ^   ^    `.\n"
                                + "   :      0   0      :                 __....._\n"
                                + "   :     _.-0-._     :---'\"\"'\"-....--'\"        '.\n"
                                + "    :  .'   :   `.  :                          `,`.\n"
                                + "     `.: '--'--' :.'                             ; ;\n"
                                + "      : `._`-'_.'                                ;.'\n"
                                + "      `.   '\"'                                   ;\n"
                                + "       `.               '                        ;\n"
                                + "        `.     `        :           `            ;\n"
                                + "         .`.    ;       ;           :           ;\n"
                                + "       .'    `-.'      ;            :          ;`.\n"
                                + "   __.'      .'      .'              :        ;   `.\n"
                                + " .'      __.'      .'`--..__      _._.'      ;      ;\n"
                                + " `......'        .'         `'\"\"'`.'        ;......-'\n"
                                + "       `.......-'                 `........'");
                        coins = coins - 200;
                    }
                    if (coins < 200) {
                        System.out.println("Sorry you dont have enough coins");
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
