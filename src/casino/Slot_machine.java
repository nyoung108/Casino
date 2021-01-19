
package casino;

import java.util.Random;
import java.util.Scanner;

public class Slot_machine {
    
    public int play(int coins){
        Scanner input= new Scanner(System.in);
        Random rand = new Random();
        boolean valid = true;
        while(valid){
        
        System.out.println("How many coins would you like to enter?");
        int pool = input.nextInt();
        coins = coins-pool;
        int a = rand.nextInt(8);
        int b = rand.nextInt(8);
        int c = rand.nextInt(8);
        System.out.println("Number one:   "+a);
        System.out.println("Number two:   "+b);
        System.out.println("Number three: "+c);
        
        if ((a==b)&&(b==c)){
            coins=coins+(pool*3);
            System.out.println("You matched all three!");
            System.out.println("Your coins: "+coins);
        }
        else if((a==b)||(a==c)||(b==c)){
            coins=coins+(pool*2);
            System.out.println("You matched two numbers!");
            System.out.println("Your coins: "+coins);
        }
        else{
            System.out.println("Better luck next time :(");
            System.out.println("Your coins: "+coins);
        }
            System.out.println("If You would like to play again enter 1");
            int again = input.nextInt();
            
            if(again!=1){
                valid = false;
            }
        
        }
        return coins;
    }
}
