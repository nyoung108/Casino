
package casino;

import java.util.Scanner;

public class Casino {

    public static void main(String[] args) {
        int coins = 100;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my Casino");
        System.out.println("You have "+coins+" coins");
        System.out.println("If you would like to play the Slot machine enter 1");
        int selected = input.nextInt();
        
        Slot_machine slot_machine = new Slot_machine();
        switch(selected){
            case 1:
                slot_machine.play(coins);
                break;
        }
    }
    
}
